package com.beneti.springtutorial02.controllers;

import com.beneti.springtutorial02.models.Person;
import com.beneti.springtutorial02.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/all")
    public List<Person> getAllPeople() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
