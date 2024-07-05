package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/dashboard")
    public String displayDashboard(Authentication authentication, Model model, HttpSession session) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", authentication.getAuthorities().toString());

        String email = authentication.getName();
        Person person = personRepository.findByEmail(email);
        session.setAttribute("person", person);
        return "dashboard.html";
    }

}
