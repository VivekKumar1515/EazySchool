package org.eazybyte.com.eazybyteschool.Repository;

import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
    public List<Contact> findByStatus(String status);
}
