package ru.hogwarts.scoolHogwart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handStudentNotFoundException(StudentNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(String.format("Студент с ip = %d не найден!", e.getId()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<String> handFacultyNotFoundException(FacultyNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(String.format("Факультет с ip = %d не найден!", e.getId()));
    }
}
