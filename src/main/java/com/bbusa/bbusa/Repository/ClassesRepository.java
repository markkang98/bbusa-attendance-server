package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import com.bbusa.bbusa.Entity.curr.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, String> {

}