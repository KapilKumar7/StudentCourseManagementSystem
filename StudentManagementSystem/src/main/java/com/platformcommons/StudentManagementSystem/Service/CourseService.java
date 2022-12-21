package com.platformcommons.StudentManagementSystem.Service;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;

import java.util.List;

public interface CourseService {

    Course uploadCourse(Course course);

    Course assignCourseToStudent(Long courseId, Long studentId);

    List<Student> getStudentsByCourse(Long courseId);

       List<Course> getCourses(Long studentId);

}
