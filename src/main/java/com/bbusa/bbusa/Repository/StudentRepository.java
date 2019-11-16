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

    @Query(value = "SELECT s.*\n" +
            "FROM innodb.ParentStudent as ps,\n" +
            "innodb.Student as s,\n" +
            "innodb.Parent as p\n" +
            "where ps.PID = p.PID and s.SID = ps.SID\n" +
            "and p.parentEmail = 'mk1@gmail.com'" , nativeQuery = true)
    List<StudentEntity> getParentsStudents(@Param("parentEmail") String parentEmail);
}