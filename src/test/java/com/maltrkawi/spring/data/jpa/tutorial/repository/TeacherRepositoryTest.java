package com.maltrkawi.spring.data.jpa.tutorial.repository;

import com.maltrkawi.spring.data.jpa.tutorial.entity.Course;
import com.maltrkawi.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDb = Course.builder()
                .title("CS-001")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("PL-001")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mohammad")
                .lastName("Altrkawi")
                //.courses(List.of(courseDb, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}