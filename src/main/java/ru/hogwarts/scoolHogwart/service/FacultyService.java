package ru.hogwarts.scoolHogwart.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scoolHogwart.exception.FacultyNotFoundException;
import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.model.Student;
import ru.hogwarts.scoolHogwart.repositories.FacultyRepository;
import ru.hogwarts.scoolHogwart.repositories.StudentRepository;

import java.util.Collection;

@Service
public class FacultyService {
   private final FacultyRepository facultyRepository;
   private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository){

        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }


    public Faculty editFaculty(long id, Faculty faculty) {
        if(!facultyRepository.findById(id).isPresent()){
            throw new FacultyNotFoundException(id);
        }
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> getAllFaculties(){

        return facultyRepository.findAll();
    }
    //метод,для поиска по цвету
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findByColorOrName(String colorOrName) {
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName);
    }
    public Collection<Student> findByFaculty(long id) {
        return studentRepository.findAllByFaculty_Id(id);
    }
}

