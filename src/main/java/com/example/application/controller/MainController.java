package com.example.application.controller;

import com.example.application.entity.Person;
import com.example.application.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class MainController {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }
}
