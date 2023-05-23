package com.beneti.springtutorial02.mapper.custom;

import com.beneti.springtutorial02.dtos.PersonDTOv2;
import com.beneti.springtutorial02.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person) {
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setBirthDay(new Date());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDTOToEntity(PersonDTOv2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;
    }

}
