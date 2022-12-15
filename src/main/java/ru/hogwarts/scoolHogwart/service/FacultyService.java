package ru.hogwarts.scoolHogwart.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scoolHogwart.model.Faculty;

import java.util.HashMap;

    @Service
    public class FacultyService {

        private final HashMap<Long, Faculty> faculties = new HashMap<>();

        private long count = 0;

        public FacultyService(){
        }

        public Faculty addFaculty(Faculty faculty) {
            faculty.setId(count++);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }

        public Faculty findFaculty(long id) {
            return faculties.get(id);
        }

        public Faculty editFaculty(long id, Faculty faculty) {
            if (!faculties.containsKey(id)) {
                return null;
            }
            faculties.put(id, faculty);
            return faculty;
        }

        public void deleteFaculty(long id) {
            faculties.remove(id);
        }
    }

