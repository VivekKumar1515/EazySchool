package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import org.eazybyte.com.eazybyteschool.Model.EazyClass;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Repository.ClassesRepository;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller()
@RequestMapping(value = "/REDACTED")
public class AdminController {
    @Autowired
    ClassesRepository classesRepository;

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/displayClasses")
    public String displayClasses(Model model) {
        List<EazyClass> classes = classesRepository.findAll();
        model.addAttribute("eazyClasses", classes);
        model.addAttribute("eazyClass", new EazyClass());
        return "classes.html";
    }

    @RequestMapping(value = "/addNewClass", method = RequestMethod.POST)
    public String addNewClass(@ModelAttribute(value = "eazyClass") EazyClass eazyClass) {
        classesRepository.save(eazyClass);
        return "redirect:/REDACTED/displayClasses";
    }

    @RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
    public String deleteClass(@RequestParam(value = "id") int classId) {
        EazyClass eazyClass = classesRepository.findById(classId).get();
        for(Person person : eazyClass.getPerson()) {
            person.setEazyclass(null);
            personRepository.save(person);
        }

        classesRepository.delete(eazyClass);
        return "redirect:/REDACTED/displayClasses";
    }

    @RequestMapping(value = "/displayStudents")
    public String displayStudents(@RequestParam(value = "classId") int classId, @RequestParam(value = "error", required = false) Integer error, Model model, HttpSession session) {
        EazyClass eazyClass = classesRepository.findById(classId).get();
        model.addAttribute("eazyClass", eazyClass);
        session.setAttribute("eazyClass", eazyClass);
        model.addAttribute("person", new Person());
        if(error != null && error == 2) {
            model.addAttribute("errorMessage", "Error: Invalid Email Address");
        }
        if(error != null && error == 1) {
            model.addAttribute("errorMessage", "Error: Cannot add Admin to a Class");
        }
        if(error != null && error == 3) {
            model.addAttribute("errorMessage", "Error: Student is already added to another class");
        }
        return "student.html";
    }

    @RequestMapping(value = "/addStudent")
    public String addStudent(@ModelAttribute(value = "person") Person student, HttpSession session) {
        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        Person person = personRepository.findByEmail(student.getEmail());
        if(person != null && person.getPersonId() > 0 && person.getRole().getRoleId() != 1) {
            if(person.getEazyclass() != null && person.getEazyclass().getClassId() > 0 && person.getEazyclass().getClassId() != eazyClass.getClassId()) {
                return "redirect:/REDACTED/displayStudents?classId=" + eazyClass.getClassId() + "&error=3";
            }
            eazyClass.getPerson().add(person);
            classesRepository.save(eazyClass);
            person.setEazyclass(eazyClass);
            personRepository.save(person);
            return "redirect:/REDACTED/displayStudents?classId=" + eazyClass.getClassId();
        } else {
            if(person != null && person.getRole().getRoleId() == 1) {
                return "redirect:/REDACTED/displayStudents?classId=" + eazyClass.getClassId() + "&error=1";
            }
            return "redirect:/REDACTED/displayStudents?classId=" + eazyClass.getClassId() + "&error=2";
        }
    }

    @RequestMapping(value = "/deleteStudent")
    public String deleteStudent(@RequestParam(value = "personId") int personId, HttpSession session) {
        Person person = personRepository.findById(personId).get();
        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        person.setEazyclass(null);
        personRepository.save(person);
        eazyClass.getPerson().remove(person);
        classesRepository.save(eazyClass);

        return "redirect:/REDACTED/displayStudents?classId=" + eazyClass.getClassId();
    }
}
