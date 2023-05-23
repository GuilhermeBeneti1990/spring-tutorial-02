package com.beneti.springtutorial02.services;

import com.beneti.springtutorial02.dtos.PersonDTO;
import com.beneti.springtutorial02.dtos.PersonDTOv2;

import java.util.List;

public interface PersonService {

    public List<PersonDTO> findAll();
    public PersonDTO findById(Long id);
    public PersonDTO create(PersonDTO person);
    public PersonDTOv2 createV2(PersonDTOv2 person);
    public PersonDTO update(PersonDTO person);
    public void delete(Long id);

}
