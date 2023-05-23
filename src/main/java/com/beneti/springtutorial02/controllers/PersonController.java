package com.beneti.springtutorial02.controllers;

import com.beneti.springtutorial02.dtos.PersonDTO;
import com.beneti.springtutorial02.dtos.PersonDTOv2;
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
    public List<PersonDTO> getAllPeople() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PostMapping("/v2")
    public PersonDTOv2 createPersonV2(@RequestBody PersonDTOv2 person) {
        return service.createV2(person);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable("id") Long id, @RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
