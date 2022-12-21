package com.platformcommons.StudentManagementSystem.Controller;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;
import com.platformcommons.StudentManagementSystem.Repository.CourseRepository;
import com.platformcommons.StudentManagementSystem.Service.CourseService;
import com.platformcommons.StudentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Student> admitStudent(@Valid @RequestBody Student student) {
        // admit a new student
        return ResponseEntity.ok(studentService.admitStudent(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateProfile(@PathVariable Long studentId, @Valid @RequestBody Student student) {
        // update a student's profile
        return ResponseEntity.ok(studentService.updateProfile(studentId, student));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) String name) {
        // search for students by name
        return ResponseEntity.ok(studentService.searchStudents(name));
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> leaveCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        // allow a student to leave a course
        studentService.leaveCourse(studentId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getCourses(@PathVariable Long studentId) {
        // get the courses assigned to a student
        return ResponseEntity.ok(courseService.getCourses(studentId));
    }

}