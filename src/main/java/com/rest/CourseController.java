package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    @GetMapping("/{id}")
    public Course getSpecificCourse(@PathVariable int id) {
        //return courseRepository.findById(id);
        return courseRepository.getOne(id);
    }

    @PostMapping("/")
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable int id, @Valid @RequestBody Course course) {
        if (!courseRepository.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(courseRepository.save(course));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseRepository.deleteById(id);
    }

}
