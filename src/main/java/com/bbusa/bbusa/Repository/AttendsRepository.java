package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendsRepository extends JpaRepository<AttendsEntity, String> {

    @Query(value = "Select a.SID, a.CID, attend_date, attendance FROM Attends as a, Student as s WHERE a.SID = s.SID AND " +
            "s.student_email = :student_email AND a.CID = :CID" , nativeQuery = true)
    List<AttendsEntity> getClassAttends(@Param("student_email") String student_email, @Param("CID") int CID);
}