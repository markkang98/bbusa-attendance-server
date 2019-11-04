package com.bbusa.bbusa.Repository.prev;

import com.bbusa.bbusa.Entity.prev.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInformationRepository extends JpaRepository<StudentEntity, String> {

    @Query(value = "SELECT * FROM students x WHERE x.instructor_id = :user_id ORDER BY x.belt_order", nativeQuery = true)
    List<StudentEntity> findAllForUser(String user_id);

    @Query(value = "SELECT * FROM students x WHERE x.belt_color = :belt_color", nativeQuery = true)
    List<StudentEntity> findByBelt(@Param("belt_color") String beltColor);
}
