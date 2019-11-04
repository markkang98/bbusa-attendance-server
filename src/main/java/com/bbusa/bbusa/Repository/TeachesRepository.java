package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import com.bbusa.bbusa.Entity.curr.RegisteredUserEntity;
import com.bbusa.bbusa.Entity.curr.TeachesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachesRepository extends JpaRepository<TeachesEntity, String> {

}