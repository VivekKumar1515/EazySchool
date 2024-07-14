package org.eazybyte.com.eazybyteschool.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Model.Response;
import org.eazybyte.com.eazybyteschool.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/contact", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class RestController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessageByStatus")
    public List<Contact> getMessageByStatus(@RequestParam String status) {
        List<Contact> contacts = contactRepository.findByStatusQuery(status);
        return contacts;
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<org.eazybyte.com.eazybyteschool.Model.Response> saveMessage(@Valid @RequestBody Contact contact, @RequestHeader("invocationFrom") String invocationFrom) {
        log.info(String.format("Invocation Header = %s", invocationFrom));
        contactRepository.save(contact);
        Response response = new Response();
        response.setStatusCode(HttpStatus.CREATED.toString());
        response.setStatusMessage("Msg Saved");
        return ResponseEntity.status(HttpStatus.CREATED).header("isSaved", "true").body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMessage(RequestEntity<Contact> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        int contactId = requestEntity.getBody().getContactId();
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        contactRepository.deleteById(contactId);
        Response response = new Response();
        response.setStatusCode(HttpStatus.OK.toString());
        response.setStatusMessage("Msg Deleted");
        return ResponseEntity.status(HttpStatus.OK).header("isDeleted", "true").body(response);
    }
}
