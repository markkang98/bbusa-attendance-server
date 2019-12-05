package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, String> {
    @Query(value = "SELECT i.IID, instructor_email, belt FROM Instructor as i, Teaches as t WHERE t.CID = :CID AND t.IID = i.IID", nativeQuery = true)
    List<InstructorEntity> getClassProfile(@Param("CID") int CID);

    @Query(value = "SELECT * FROM Instructor WHERE Instructor.instructor_email = :instructor_email", nativeQuery = true)
    List<InstructorEntity> getInstructor(@Param("instructor_email") String instructor_email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Instructor SET Instructor.instructor_email = :instructor_email, Instructor.belt = :belt WHERE Instructor.instructor_email = :original_email", nativeQuery = true)
    void update(@Param("instructor_email") String instructor_email, @Param("belt") String belt, @Param("original_email") String originalEmail);
}