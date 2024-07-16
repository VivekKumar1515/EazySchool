package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {
    @Autowired
    PersonRepository personRepository;

    @Value("${eazyschool.pageSize}")
    private int defaultPageSize;

    @Value("${eazyschool.contact.successMsg}")
    private String successMsg;

    @Autowired
    Environment environment;

    @RequestMapping(value = "/dashboard")
    public String displayDashboard(Authentication authentication, Model model, HttpSession session) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", authentication.getAuthorities().toString());

        String email = authentication.getName();
        Person person = personRepository.findByEmail(email);
        session.setAttribute("person", person);
        logMessages();
        return "dashboard.html";
    }

    public void logMessages() {
        log.error("default pageSize value with @value annotation is : " + defaultPageSize);
        log.error("successMsg value with @Value annotation is : " + successMsg);

        log.error("default pageSize value with Environment is : " + environment.getProperty("eazyschool.pageSize"));
        log.error("successMsg value with Environment is : " + environment.getProperty("eazyschool.contact.successMsg"));
        log.error("Username environment variable using Environment is : " + environment.getProperty("USERNAME"));
    }

}
