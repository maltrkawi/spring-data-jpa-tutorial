package com.maltrkawi.spring.data.jpa.tutorial.repository;

import com.maltrkawi.spring.data.jpa.tutorial.entity.Guardian;
import com.maltrkawi.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("f.altrkawi@gmail.com")
                .firstName("Fares")
                .lastName("Altrkawi")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Mohammad Altrkawi")
                .email("m.altrkawi@gmail.com")
                .mobile("966564111652")
                .build();

        Student student = Student.builder()
                .firstName("Julia")
                .lastName("Altrkawi")
                .emailId("j.altrkawi@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList" + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Julia");
        System.out.println("studentList" + studentList);
    }

    @Test
    public void printStudentByFirstNameContains(){
        List<Student> studentList = studentRepository.findByFirstNameContains("Ju");
        System.out.println("studentList" + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Mohammad");
        System.out.println("studentList" + studentList);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("f.altrkawi@gmail.com");
        System.out.println("student: " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("f.altrkawi@gmail.com");
        System.out.println("student first name: " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("j.altrkawi@gmail.com");
        System.out.println("student: " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("f.altrkawi@gmail.com");
        System.out.println("student: " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int result = studentRepository.updateStudentNameByEmailId("Faris Alterkawi", "f.altrkawi@gmail.com");
        System.out.println("No of updated records: " + result);
    }
}