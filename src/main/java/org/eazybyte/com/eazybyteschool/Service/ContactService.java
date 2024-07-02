package org.eazybyte.com.eazybyteschool.Service;

import org.eazybyte.com.eazybyteschool.Constants.EazyByteContants;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    ContactRepository repo;

    @Autowired
    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public boolean saveMessageDetails(Contact contact) {
        contact.setStatus(EazyByteContants.OPEN);
        repo.save(contact);
        return true;
    }

    public List<Contact> getMessages() {
        return repo.findByStatus(EazyByteContants.OPEN);
    }

    public boolean closeMessage(int contactId, String name) {
        Optional<Contact> contact = repo.findById(contactId);
        if(contact.isPresent()) {
            contact.get().setStatus(EazyByteContants.CLOSE);
        }
        Contact savedContact = repo.save(contact.get());
        return savedContact != null? true : false;
    }
}
