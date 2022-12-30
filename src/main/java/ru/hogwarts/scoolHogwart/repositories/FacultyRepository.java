package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scoolHogwart.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByFacultyName(String name);
    Faculty findByFacultyColor(String color);
}
