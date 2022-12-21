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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student admitStudent(Student student) {
        // implement the logic to admit a new student
        return studentRepository.save(student);
    }

    @Override
    public Student updateProfile(Long studentId, Student student) {
        // implement the logic to update a student's profile
        Student existingStudent = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student" ,"StudentId",studentId));
        existingStudent.setName(student.getName());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setGender(student.getGender());
        existingStudent.setStudentCode(student.getStudentCode());
        existingStudent.setAddresses(student.getAddresses());
        return studentRepository.save(existingStudent);

    }

    @Override
    public List<Student> searchStudents(String name) {
        // implement the logic to search for students by name
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void leaveCourse(Long studentId, Long courseId) {
        // implement the logic to allow a student to leave a course
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student","StudentId",studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course" ,"CourseId",courseId));
        student.getCourses().remove(course);
        course.getStudents().remove(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }


}
