package com.aijuancai;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
