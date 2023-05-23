package com.beneti.springtutorial02.dtos;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
