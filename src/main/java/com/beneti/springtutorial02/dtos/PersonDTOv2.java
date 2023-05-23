package com.beneti.springtutorial02.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTOv2 {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String gender;


}
