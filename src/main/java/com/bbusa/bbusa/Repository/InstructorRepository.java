package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, String> {
    @Query(value = "SELECT i.IID, instructor_email, belt FROM Instructor as i, Teaches as t WHERE t.CID = :CID AND t.IID = i.IID", nativeQuery = true)
    List<InstructorEntity> getClassProfile(@Param("CID") int CID);
}