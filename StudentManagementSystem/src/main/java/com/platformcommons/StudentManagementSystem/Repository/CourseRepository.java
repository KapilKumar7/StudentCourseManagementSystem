package com.platformcommons.StudentManagementSystem.Repository;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContainingIgnoreCase(String name);

   List<Course> findByStudents_Id(Long studentId);

}
