package com.maltrkawi.spring.data.jpa.tutorial.repository;

import com.maltrkawi.spring.data.jpa.tutorial.entity.Course;
import com.maltrkawi.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title(".NET")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.material-without-course.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}