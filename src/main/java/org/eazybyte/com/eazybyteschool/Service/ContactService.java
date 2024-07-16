package org.eazybyte.com.eazybyteschool.Service;

import org.eazybyte.com.eazybyteschool.Config.PropertiesConfiguration;
import org.eazybyte.com.eazybyteschool.Constants.EazyByteContants;
import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.eazybyte.com.eazybyteschool.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    private final ContactRepository contactRepository;
    ContactRepository repo;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Autowired
    public ContactService(ContactRepository repo, ContactRepository contactRepository) {
        this.repo = repo;
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact) {
        contact.setStatus(EazyByteContants.OPEN);
        repo.save(contact);
        return true;
    }

    public List<Contact> getMessages() {
        return repo.findByStatusQuery(EazyByteContants.OPEN);
    }

    public boolean closeMessage(int contactId, String name) {
        Optional<Contact> contact = repo.findById(contactId);
        if(contact.isPresent()) {
            contact.get().setStatus(EazyByteContants.CLOSE);
        }
        Contact savedContact = repo.save(contact.get());
        return savedContact != null? true : false;
    }

    public Page findMsgWithOpenStatus(int pageNum, String sortField, String sortDir) {
        int pageSize = propertiesConfiguration.getPageSize();
        if(propertiesConfiguration.getContact() != null && propertiesConfiguration.getContact().get("pageSize") != null) {
            pageSize = Integer.parseInt(propertiesConfiguration.getContact().get("pageSize").trim());
        }
        Pageable pageable = PageRequest.of(pageNum-1, pageSize, sortDir.equals("asc")? Sort.by(sortField).ascending(): Sort.by(sortField).descending());
        Page<Contact> page = contactRepository.findByStatus(EazyByteContants.OPEN, pageable);
        return page;
    }
}
