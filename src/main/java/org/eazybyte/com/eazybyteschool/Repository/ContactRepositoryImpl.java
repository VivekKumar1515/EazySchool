package org.eazybyte.com.eazybyteschool.Repository;

import org.eazybyte.com.eazybyteschool.Constants.EazyByteContants;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ContactRepositoryImpl {

    ContactRepository contactRepository;
    @Autowired
    public ContactRepositoryImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveMessage(Contact contact) {
        boolean saved = false;
        Contact savedContact = contactRepository.save(contact);
        if(savedContact!=null) {
            saved = true;
        }
        return saved;
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = contactRepository.findByStatus(EazyByteContants.OPEN);
        return contacts;
    }

    public boolean closeMessage(int id, String name) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            contact.get().setStatus(EazyByteContants.CLOSE);
            contact.get().setUpdatedAt(LocalDateTime.now());
            contact.get().setUpdatedBy(name);
        }
        Contact savedContact = contactRepository.save(contact.get());
        if(savedContact!=null) {
            isUpdated = true;
        }

        return isUpdated;
    }
}
