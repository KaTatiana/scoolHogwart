package ru.hogwarts.scoolHogwart.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scoolHogwart.exception.FacultyNotFoundException;
import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
   private final FacultyRepository facultyRepository;
   private long idGenerator = 1;

    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        if(facultyRepository.findById(id)==null){
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


    public Faculty findByFacultyName(String name){

        return facultyRepository.findByFacultyName(name);
    }

    public Faculty findByFacultyColor(String color){

        return facultyRepository.findByFacultyColor(color);
    }
}

