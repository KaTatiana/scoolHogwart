package ru.hogwarts.scoolHogwart.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scoolHogwart.exception.StudentNotFoundException;
import ru.hogwarts.scoolHogwart.model.Faculty;
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
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id);
    }

    public Student editStudent(long id, Student student) {
        if(studentRepository.findById(id)==null){
            throw new StudentNotFoundException(id);
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // метод для поиска по возрасту
    public Collection<Student> findByAge(int age){
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max){
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findByName(long id) {
        return studentRepository.findByFaculty_Id(id);
    }

}
