package org.eazybyte.com.eazybyteschool.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Service.ContactService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @RequestMapping(value="/displayMessages/page/{page}", method = GET)
    public String displayMessages(Model model, @PathVariable(value = "page") int pageNum, @RequestParam(value = "sortField") String sortField, @RequestParam(value = "sortDir") String sortDir, HttpSession session) {
        Page<Contact> msgPage = contactService.findMsgWithOpenStatus(pageNum, sortField, sortDir);
        List<Contact> msgList = msgPage.getContent();
        if(pageNum > msgPage.getTotalPages()+1) {
            return "redirect:/displayMessages/page/1?sortField=" + sortField + "&sortDir=" + sortDir;
        }
        model.addAttribute("totalPages", msgPage.getTotalPages());
        model.addAttribute("currentPage", msgPage.getNumber()+1);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("contactMsgs", msgList);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        session.setAttribute("sortField", sortField);
        session.setAttribute("sortDir", sortDir);

        return "messages.html";
    }

    @RequestMapping(value = "/closeMsg", method= GET)
    public String closeMsg(@RequestParam(value = "id") int id, Authentication authentication, HttpSession session) {
        contactService.closeMessage(id, authentication.getName());

        return "redirect:/displayMessages/page/1?sortField=" + session.getAttribute("sortField") + "&sortDir=" + session.getAttribute("sortDir");
    }
}