package org.eazybyte.com.eazybyteschool.Service;

import org.eazybyte.com.eazybyteschool.Constants.EazyByteContants;
import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Model.Roles;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.eazybyte.com.eazybyteschool.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;
    RolesRepository rolesRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean savePerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.findByRoleName(EazyByteContants.STUDENT_ROLE);
        person.setRole(role);
        person.setPwd(passwordEncoder.encode(person.getPwd())); //saving the hashed password
        Person savedPerson = personRepository.save(person);
        if(savedPerson != null) {
            isSaved = true;
        }

        return isSaved;
    }
}
