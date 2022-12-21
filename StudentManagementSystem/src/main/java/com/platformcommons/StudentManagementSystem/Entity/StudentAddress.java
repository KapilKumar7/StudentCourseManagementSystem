package com.platformcommons.StudentManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.platformcommons.StudentManagementSystem.Enum.AddressType;

import lombok.Data;

@Data
@Entity
@Table(name = "student_addresses")
public class StudentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String area;


    private String state;


    private String district;

    private String pincode;


    @Enumerated(EnumType.STRING)
    private AddressType addressType;


    @ManyToOne
    private Student student;


}
