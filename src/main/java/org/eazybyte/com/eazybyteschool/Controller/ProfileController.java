package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.eazybyte.com.eazybyteschool.Model.Address;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Model.Profile;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "profileControllerBean")
public class ProfileController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/displayProfile")
    public ModelAndView displayProfile(Authentication auth, Model model, HttpSession session) {
        Profile profile = new Profile();
        Person person = (Person) session.getAttribute("person");
        profile.setName(person.getName());
        profile.setEmail(person.getEmail());
        profile.setMobileNumber(person.getMobileNumber());
        if(person.getAddress() != null && person.getAddress().getAddressId() >= 0) {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZip_code());
        }
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile", profile);
        System.out.println(profile.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("profile") Profile profile, Authentication auth, Model model, Errors errors, HttpSession session) {
        if(errors.hasErrors()) {
            return "profile.html";
        }

        Person person = (Person) session.getAttribute("person");
        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNumber(profile.getMobileNumber());

        if(person.getAddress() == null || !(person.getAddress().getAddressId() >= 0)) {
            person.setAddress(new Address());
        }

        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZip_code(profile.getZipCode());
        personRepository.save(person);
        session.setAttribute("person", person);

        return "redirect:/displayProfile";
    }
}
