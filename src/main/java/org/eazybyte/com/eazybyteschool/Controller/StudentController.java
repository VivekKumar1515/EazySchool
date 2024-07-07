package org.eazybyte.com.eazybyteschool.Controller;

import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.Authenticator;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "displayCourses")
    public String displayCourses(Authentication authenticate, Model model) {
        String email = authenticate.getName();
        Person person = personRepository.findByEmail(email);
        model.addAttribute("person", person);
        return "courses_enrolledStudent.html";
    }
}
