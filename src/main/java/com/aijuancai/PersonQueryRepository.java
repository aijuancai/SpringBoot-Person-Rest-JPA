package com.aijuancai;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personQueryRepository")
public interface PersonQueryRepository extends JpaRepository<Person, Integer>{
    public List<Person> findByFirstNameLike(String firstName);
    public List<Person> findByLastName(String lastName);
}
