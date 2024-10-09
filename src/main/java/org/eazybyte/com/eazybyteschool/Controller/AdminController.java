package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import org.eazybyte.com.eazybyteschool.Model.Courses;
import org.eazybyte.com.eazybyteschool.Model.EazyClass;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Repository.ClassesRepository;
import org.eazybyte.com.eazybyteschool.Repository.CoursesRepository;
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
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ClassesRepository classesRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CoursesRepository coursesRepository;


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
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
    public String deleteClass(@RequestParam(value = "id") int classId) {
        EazyClass eazyClass = classesRepository.findById(classId).get();
        for(Person person : eazyClass.getPerson()) {
            person.setEazyclass(null);
            personRepository.save(person);
        }

        classesRepository.delete(eazyClass);
        return "redirect:/admin/displayClasses";
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
                return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=3";
            }
            eazyClass.getPerson().add(person);
            classesRepository.save(eazyClass);
            person.setEazyclass(eazyClass);
            personRepository.save(person);
            return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId();
        } else {
            if(person != null && person.getRole().getRoleId() == 1) {
                return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=1";
            }
            return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=2";
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

        return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId();
    }

    @RequestMapping(value = "/displayCourses")
    public String displayCourses(Model model, HttpSession session) {
        List<Courses> courses = coursesRepository.findAll();
        Courses course = new Courses();
        model.addAttribute("courses", courses);
        model.addAttribute("course", course);
        return "courses_admin.html";
    }

    @RequestMapping(value = "/addNewCourse", method = RequestMethod.POST)
    public String addNewCourse(@ModelAttribute(value = "course") Courses course, Model model, HttpSession session) {
        coursesRepository.save(course);
        return "redirect:/admin/displayCourses";
    }

    @RequestMapping(value = "/viewStudents")
    public String viewStudents(@RequestParam(value = "id") int courseId, Model model, HttpSession session, @RequestParam(value = "error", required = false) Integer error) {
        Courses course = coursesRepository.findById(courseId).get();
        Person person = new Person();
        model.addAttribute("person", person);
        model.addAttribute("courses", course);
        session.setAttribute("course", course);
        if(error != null && error == 1) {
            model.addAttribute("errorMessage", "Error: Invalid Email Address");
        }
        return "courses_student.html";
    }

    @RequestMapping(value = "addStudentToCourse", method = RequestMethod.POST)
    public String addStudentToCourse(@ModelAttribute(value = "person") Person Student, Model model, HttpSession session) {
        Courses course = (Courses) session.getAttribute("course");
        course.getStudents().add(Student);
        coursesRepository.save(course);

        Person person = personRepository.findByEmail(Student.getEmail());
        if(person == null || !(person.getPersonId() > 0)) {
            return "redirect:/admin/viewStudents?id=" + course.getCourseId() + "&error=1";
        }
        person.getEnrolledCourses().add(course);
        personRepository.save(person);
        session.setAttribute("course", course);
        return "redirect:/admin/viewStudents?id=" + course.getCourseId();
    }
    @RequestMapping(value = "deleteStudentFromCourse")
    public String deleteStudentFromCourse(@RequestParam(value = "personId") int personId, Model model, HttpSession session) {
        Courses course = (Courses) session.getAttribute("course");
        Person person = personRepository.findById(personId).get();
        course.getStudents().remove(person);
        person.getEnrolledCourses().remove(course);
        personRepository.save(person);
        coursesRepository.save(course);
        session.setAttribute("course", course);

        return "redirect:/admin/viewStudents?id=" + course.getCourseId();
    }

}
