package com.platformcommons.StudentManagementSystem.Repository;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String name);
//    List<Course> getCourseByStudentCodeCourseList(Long studentId);
}
