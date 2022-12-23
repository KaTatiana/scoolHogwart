package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scoolHogwart.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
