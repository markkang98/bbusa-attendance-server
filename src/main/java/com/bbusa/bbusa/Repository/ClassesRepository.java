package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, String> {
    @Query(value = "SELECT t.CID, start_time, end_time, target_start_age, target_older_age, description " +
            "FROM Classes as c, Student as s, Takes as t WHERE s.student_email = :student_email AND t.SID = s.SID AND c.CID = t.CID", nativeQuery = true)
    List<ClassesEntity> getListOfClassesOfStudent(@Param("student_email") String student_email);

    @Query(value = "SELECT t.CID, start_time, end_time, target_start_age, target_older_age, description " +
            "FROM Classes as c, Instructor as i, Teaches as t WHERE i.instructor_email = :instructor_email AND t.IID = i.IID AND c.CID = t.CID", nativeQuery = true)
    List<ClassesEntity> getListOfClassesOfInstructor(@Param("instructor_email") String instructor_email);

    @Query(value = "SELECT MAX(CID) FROM Classes", nativeQuery = true)
    int getMaxCID();

}