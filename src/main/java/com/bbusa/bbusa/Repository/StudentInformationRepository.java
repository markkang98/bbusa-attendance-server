package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInformationRepository extends JpaRepository<StudentEntity, String> {

    @Override
    @Query(value = "SELECT * FROM trial_database.students x ORDER BY x.belt_order", nativeQuery = true)
    List<StudentEntity> findAll();
    @Query(value = "SELECT * FROM trial_database.students x WHERE x.belt_color = :belt_color", nativeQuery = true)
    List<StudentEntity> findByBelt(@Param("belt_color") String beltColor);
}
