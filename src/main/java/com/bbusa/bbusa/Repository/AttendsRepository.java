package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendsRepository extends JpaRepository<AttendsEntity, String> {

    @Query(value = "Select attendDate, attendance from innodb.Attends as a Join innodb.Student as s on a.sid = s.SID" +
            "where a.SID = :student_email and a.CID = :class_id;" , nativeQuery = true)
    List<AttendsEntity> getClassAttends(@Param("student_email") String student_email, @Param("class_id") int class_id );

    @Query(value = "Select SID, CID, attendDate, attendance from innodb.Attends as a Join innodb.Student as s on a.sid = s.SID" +
            "where s.student_email =  = :student_email;" , nativeQuery = true)
    List<AttendsEntity> getAllAttends(@Param("student_email") String student_email);
}