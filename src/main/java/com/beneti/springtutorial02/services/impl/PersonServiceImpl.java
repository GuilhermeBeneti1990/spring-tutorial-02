package com.beneti.springtutorial02.services.impl;

import com.beneti.springtutorial02.dtos.PersonDTO;
import com.beneti.springtutorial02.dtos.PersonDTOv2;
import com.beneti.springtutorial02.exceptions.ResourceNotFoundException;
import com.beneti.springtutorial02.mapper.DozerMapper;
import com.beneti.springtutorial02.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper mapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding all people...");

        return DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding person with id: " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return DozerMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person...");

        var entity = DozerMapper.parseObject(person, Person.class);
        var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);

        return dto;

    }

    public PersonDTOv2 createV2(PersonDTOv2 person) {
        logger.info("Creating person...");

        var entity = mapper.convertDTOToEntity(person);
        var dto = mapper.convertEntityToDTO(repository.save(entity));

        return dto;

    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating person...");

        var personToUpdate = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAddress(person.getAddress());
        personToUpdate.setGender(person.getGender());

        var dto = DozerMapper.parseObject(repository.save(personToUpdate), PersonDTO.class);

        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting person...");

        var personToRemove = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(personToRemove);
    }

}
