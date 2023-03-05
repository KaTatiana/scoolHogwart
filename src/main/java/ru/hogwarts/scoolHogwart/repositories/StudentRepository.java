package ru.hogwarts.scoolHogwart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.scoolHogwart.model.Faculty;
import ru.hogwarts.scoolHogwart.model.Student;
import ru.hogwarts.scoolHogwart.model.StudentByEndStudents;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);
    Collection<Student> findAllByFaculty_Id(long facultyId);
    Student findById(long id);
    Faculty findByFaculty_Id(long id);

    @Query(value = "SELECT Count(*) FROM students", nativeQuery = true)
    Integer studentByQuantity();

    @Query(value = "SELECT SUM(age)/(Count(*)) from students", nativeQuery = true)
    Integer studentByAverageAge();

    @Query(value = "SELECT * from students ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<StudentByEndStudents> getStudentByEndStudents();


}
