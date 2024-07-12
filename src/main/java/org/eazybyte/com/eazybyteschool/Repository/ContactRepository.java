package org.eazybyte.com.eazybyteschool.Repository;

import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
//  @Query(value = "SELECT * FROM contact_msg WHERE status = :status", nativeQuery = true)
  @Query("SELECT c FROM Contact c WHERE c.status = :status")
    public List<Contact> findByStatus(@Param(value = "status") String status);

    public Page<Contact> findByStatus(String status, Pageable pageable);
}
