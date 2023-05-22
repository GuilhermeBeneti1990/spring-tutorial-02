package com.beneti.springtutorial02.services.impl;

import com.beneti.springtutorial02.models.Person;
import com.beneti.springtutorial02.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            people.add(person);
        }

        return people;
    }

    public Person findById(String id) {
        logger.info("Finding person...");

        Person person = new Person();
        person.setId(new AtomicLong().incrementAndGet());
        person.setFirstName("Guilherme");
        person.setLastName("Beneti");
        person.setAddress("Via Carlo Cattaneo - Pisa/IT");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating person...");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person...");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting person...");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(new AtomicLong().incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address - " + i);
        person.setGender("Male");

        return person;
    }

}
