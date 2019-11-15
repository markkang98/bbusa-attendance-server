package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Query(value = "SELECT * FROM Student WHERE Student.student_email = :student_email" , nativeQuery = true)
    List<StudentEntity> getStudentProfile(@Param("student_email") String student_email);
}