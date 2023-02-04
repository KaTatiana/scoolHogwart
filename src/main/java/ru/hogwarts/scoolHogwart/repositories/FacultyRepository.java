package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scoolHogwart.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty>findByColor(String color);
    Collection<Faculty>findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);
}
