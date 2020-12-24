package com.mann.controller;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vladimir Mann
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer departmentId;

    private String name;

    private String secondName;

    private String patronymicName;

    private LocalDate dateOfBirth;

    private Long salary;
}


