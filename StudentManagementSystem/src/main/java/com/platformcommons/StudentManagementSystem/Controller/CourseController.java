package com.platformcommons.StudentManagementSystem.Controller;

import com.platformcommons.StudentManagementSystem.Entity.Course;
import com.platformcommons.StudentManagementSystem.Entity.Student;
import com.platformcommons.StudentManagementSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> uploadCourse(@Valid @RequestBody Course course) {
        // upload a new course
        return ResponseEntity.ok(courseService.uploadCourse(course));
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Course> assignCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        // assign a course to a student
        return ResponseEntity.ok(courseService.assignCourseToStudent(courseId, studentId));
    }

//    @GetMapping("/{courseId}/students")
//    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Long courseId) {
//        // get the students enrolled in a particular course
//        return ResponseEntity.ok(courseService.getStudentsByCourse(courseId));
//    }

}
