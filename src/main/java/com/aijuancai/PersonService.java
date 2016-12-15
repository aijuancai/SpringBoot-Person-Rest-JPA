package com.aijuancai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonQueryRepository personQueryRepository;

    public List<Person> searchByFirstName(String firstName) {
        return personQueryRepository.findByFirstNameLike(firstName);
    }

    public List<Person> searchByLasttName(String firstName) {
        return personQueryRepository.findByLastName(firstName);
    }

    public List<Person> findAll() {
        return personQueryRepository.findAll();
    }

    public Person createPerson(String firstName, String lastName) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        return personRepository.save(p);
    }
}
