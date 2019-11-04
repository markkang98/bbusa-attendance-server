package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, String> {

}