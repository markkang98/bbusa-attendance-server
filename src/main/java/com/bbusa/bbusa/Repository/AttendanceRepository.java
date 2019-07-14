package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, String> {

    @Query(value = "SELECT * FROM attendance x WHERE x.first_name = :first_name AND x.last_name = :last_name", nativeQuery = true)
    List<AttendanceEntity> findAttendanceDatesForStudent(String first_name, String last_name);

}
