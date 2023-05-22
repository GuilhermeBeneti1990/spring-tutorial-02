package com.beneti.springtutorial02.controllers;

import com.beneti.springtutorial02.models.Person;
import com.beneti.springtutorial02.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

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

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.delete(id);
    }

}
