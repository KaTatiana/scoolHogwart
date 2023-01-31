package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);
    Collection<Student> findAllByFaculty_Id(long facultyId);
    Student findById(long id);
    Faculty findByFaculty_Id(long id);
}
