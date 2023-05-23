package com.beneti.springtutorial02.services;

import com.beneti.springtutorial02.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    public List<PersonDTO> findAll();
    public PersonDTO findById(Long id);
    public PersonDTO create(PersonDTO person);
    public PersonDTO update(PersonDTO person);
    public void delete(Long id);

}
