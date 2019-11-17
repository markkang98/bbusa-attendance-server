package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.ParentEntity;
import com.bbusa.bbusa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, String> {
    @Query(value = "SELECT s.*\n" +
            "FROM innodb.ParentStudent as ps,\n" +
            "innodb.Student as s,\n" +
            "innodb.Parent as p\n" +
            "where ps.PID = p.PID and s.SID = ps.SID\n" +
            "and p.parent_email = :parentEmail" , nativeQuery = true)
    List<StudentEntity> getParentsStudents(@Param("parentEmail") String parentEmail);

    @Query(value = "SELECT * \n" +
            "FROM innodb.Parent as p\n" +
            "where p.parent_email = :parentEmail" , nativeQuery = true)
    List<ParentEntity> getParentProfile(@Param("parentEmail") String parentEmail);



}