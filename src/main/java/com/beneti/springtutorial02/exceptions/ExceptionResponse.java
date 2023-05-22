package com.beneti.springtutorial02.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1l;

    private Date timestamp;
    private String message;
    private String details;

}
