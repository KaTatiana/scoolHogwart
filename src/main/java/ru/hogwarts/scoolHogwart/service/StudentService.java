package ru.hogwarts.scoolHogwart.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scoolHogwart.model.Student;
import ru.hogwarts.scoolHogwart.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
