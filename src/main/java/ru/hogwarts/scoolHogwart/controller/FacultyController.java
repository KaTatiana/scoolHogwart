package ru.hogwarts.scoolHogwart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id, @RequestParam String name, @RequestParam String color) {
        Faculty faculty = facultyService.findFaculty(id);

        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
  //  @GetMapping
  //  public ResponseEntity<Collection<Faculty>> getAllFaculties() {return ResponseEntity.ok(facultyService.getAllFaculties());}

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@PathVariable long id, @RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(id, faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public Collection<Faculty>findByColor(@RequestParam String color){
        return facultyService.findByColor(color);
    }
    @GetMapping(params = "colorOrName")
    public Collection<Faculty>findByColorOrName(@RequestParam String colorOrName){
        return facultyService.findByColorOrName(colorOrName);
    }
}