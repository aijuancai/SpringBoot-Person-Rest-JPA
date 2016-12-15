package com.aijuancai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {
    //private final AtomicLong counter = new AtomicLong();
    @Autowired
    PersonService personService;

    @RequestMapping(value="/create/firstName/{firstName}/lastName/{lastName}")
    public Person addPerson(@PathVariable final String firstName,
                            @PathVariable final String lastName) {
        return personService.createPerson(firstName, lastName);
    }

    @RequestMapping(value="/findByFirstName/{firstName}", method = RequestMethod.GET)
    public List<Person> getPersonsByFirstName(@PathVariable final String firstName) {
        return personService.searchByFirstName(firstName);
    }

    @RequestMapping(value="/findByLastName/{lastName}", method = RequestMethod.GET)
    public List<Person> getPersonsByLastName(@PathVariable final String lastName) {
        return personService.searchByLasttName(lastName);
    }

    @RequestMapping(value="/findAll", method=RequestMethod.GET)
    public List<Person> findAll() {
        return personService.findAll();
    }
}
