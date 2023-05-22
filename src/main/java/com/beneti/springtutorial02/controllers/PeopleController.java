package com.beneti.springtutorial02.controllers;

import com.beneti.springtutorial02.models.Person;
import com.beneti.springtutorial02.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return personService.findById(id);
    }

}
