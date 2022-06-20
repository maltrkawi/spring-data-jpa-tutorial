package com.maltrkawi.spring.data.jpa.tutorial.repository;

import com.maltrkawi.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContains(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM student WHERE email_address = ?1"
    )
    Student getStudentByEmailAddressNative(String emailId);

    // Native Named Param
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM student WHERE email_address = :emailId"
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
}
