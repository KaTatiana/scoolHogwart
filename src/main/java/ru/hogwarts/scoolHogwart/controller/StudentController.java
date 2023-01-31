package ru.hogwarts.scoolHogwart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.model.Student;
import ru.hogwarts.scoolHogwart.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents(@RequestParam int min, @RequestParam int max) {
        if(min!=-1&&max!=-1){
            return ResponseEntity.ok(studentService.findByAgeBetween(min,max));
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@PathVariable long id, @RequestBody Student student) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(params = "age")
    public Collection<Student> findByAge(@RequestParam int age){
        return studentService.findByAge(age);
    }
    @GetMapping(params = "minAge, maxAge")
    public Collection<Student> findByAgeBetween(@RequestParam int minAge, @RequestParam int maxAge){
        return studentService.findByAgeBetween(minAge, maxAge);
    }
    @GetMapping(params = "/{id}/faculty")
    public Faculty findByName(@RequestParam long id)
    {
        return studentService.findByName(id);
    }
}