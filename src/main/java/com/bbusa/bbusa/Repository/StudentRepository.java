package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Query(value = "SELECT * FROM Student WHERE Student.student_email = :student_email" , nativeQuery = true)
    List<StudentEntity> getStudentProfile(@Param("student_email") String student_email);

    @Query(value = "SELECT * FROM Student WHERE Student.SID = :SID" , nativeQuery = true)
    List<StudentEntity> getStudentProfileBySID(int SID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Student SET Student.belt = :belt, Student.age = :age, Student.emergency_contact_name = :emergency_contact_name, " +
            "Student.emergency_contact_number = :emergency_contact_number WHERE Student.student_email = :email", nativeQuery = true)
    void update(String email, String belt, int age, String emergency_contact_name, String emergency_contact_number);

}