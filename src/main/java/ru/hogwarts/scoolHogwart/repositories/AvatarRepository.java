package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scoolHogwart.model.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
