package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Service.ContactService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@Controller
public class ContactController {


    @Autowired
    ContactService contactService;

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

//    @RequestMapping(value = "/saveMsg", method = POST)
//    public ModelAndView saveInfo(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        logger.info("Name: " + name);
//        logger.info("Mobile Number: " + mobileNum);
//        logger.info("Email: " + email);
//        logger.info("Subject: " + subject);
//        logger.info("Message: " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value="/saveMsg", method=POST)
    public String saveMsg(@Valid  @ModelAttribute("contact") Contact contact, Errors errors) {
//        contactService.saveMessageDetails(contact);
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value="/displayMessages", method = GET)
    public ModelAndView displayMessages(ModelAndView modelAndView, Errors errors) {
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
        }

        List<Contact> contacts = contactService.getMessages();
        modelAndView.addObject("contactMsgs", contacts);
        modelAndView.setViewName("messages.html");

        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg", method= GET)
    public String closeMsg(@RequestParam(value = "id") int id, Authentication authentication) {
        contactService.closeMessage(id, authentication.getName());

        return "redirect:/displayMessages";
    }
}