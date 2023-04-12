package com.example.application.repository;

import com.example.application.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Iterable<Person> findAll();
}
