package org.eazybyte.com.eazybyteschool.Service;

import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Repository.ContactRepository;
import org.eazybyte.com.eazybyteschool.Repository.ContactRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {


    ContactRepositoryImpl repo;

    private ContactService(ContactRepositoryImpl repo) {
        this.repo = repo;
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean result = repo.saveMessage(contact);
        return result;
    }

    public List<Contact> getMessages() {
        List<Contact> contacts = repo.getContacts();
        return contacts;
    }

    public boolean closeMessage(int contactId, String name) {
        boolean result = repo.closeMessage(contactId, name);

        return result;
    }
}
