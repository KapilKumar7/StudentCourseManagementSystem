package com.platformcommons.StudentManagementSystem.Service;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;
import com.platformcommons.StudentManagementSystem.Exception.ResourceNotFoundException;
import com.platformcommons.StudentManagementSystem.Repository.CourseRepository;
import com.platformcommons.StudentManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Course uploadCourse(Course course) {
        // implement the logic to upload a new course
        return courseRepository.save(course);
    }

    @Override
    public Course assignCourseToStudent(Long courseId, Long studentId) {
        // implement the logic to assign a course to a student
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course","CourseId" ,courseId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student","StudentId",studentId));
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        return courseRepository.save(course);
    }

    @Override
    public List<Student> getStudentsByCourse(Long courseId) {
        // implement the logic to get the students enrolled in a particular course
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course","CourseId",courseId));
        return course.getStudents();
    }

    @Override
    public List<Course> getCourses(Long studentId) {
      return   courseRepository.findByStudents_Id(studentId);
    }

}
