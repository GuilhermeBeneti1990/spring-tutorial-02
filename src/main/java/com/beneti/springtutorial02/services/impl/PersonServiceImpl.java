package com.beneti.springtutorial02.services.impl;

import com.beneti.springtutorial02.exceptions.ResourceNotFoundException;
import com.beneti.springtutorial02.models.Person;
import com.beneti.springtutorial02.repositories.PersonRepository;
import com.beneti.springtutorial02.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding person with id: " + id);

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating person...");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating person...");

        var personToUpdate = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAddress(person.getAddress());
        personToUpdate.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting person...");

        var personToRemove = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(personToRemove);
    }

}
