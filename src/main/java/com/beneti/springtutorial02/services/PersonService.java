package com.beneti.springtutorial02.services;

import com.beneti.springtutorial02.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    public Person findById(String id);
    public Person create(Person person);
    public Person update(Person person);
    public void delete(String id);

}
