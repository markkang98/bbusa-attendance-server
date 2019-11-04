package com.bbusa.bbusa.Repository;
import com.bbusa.bbusa.Entity.AttendanceEntity;
import com.bbusa.bbusa.Entity.curr.RegisteredUserEntity;
import com.bbusa.bbusa.Entity.curr.TakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakesRepository extends JpaRepository<TakesEntity, String> {

}