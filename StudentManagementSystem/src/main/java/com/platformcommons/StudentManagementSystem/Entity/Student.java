package com.platformcommons.StudentManagementSystem.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.platformcommons.StudentManagementSystem.Enum.Gender;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


    private String studentCode;



    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudentAddress> addresses=new ArrayList<>();


    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
