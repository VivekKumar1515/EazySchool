package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.validation.Valid;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "public")
public class PublicController {

    @RequestMapping(value = "/register")
    public String registerUser(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        return "register.html";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(value = "person") Person person, Errors errors) {
        if(errors.hasErrors()) {
            return "register.html";
        } else {
            return "redirect:/login?register=true";
        }
    }
}
