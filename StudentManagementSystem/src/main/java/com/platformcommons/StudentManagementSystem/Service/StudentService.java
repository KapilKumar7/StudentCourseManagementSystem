package com.platformcommons.StudentManagementSystem.Service;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;

import java.util.List;

public interface StudentService {

    Student admitStudent(Student student);

    Student updateProfile(Long studentId, Student student);

    List<Student> searchStudents(String name);

    void leaveCourse(Long studentId, Long courseId);


}
