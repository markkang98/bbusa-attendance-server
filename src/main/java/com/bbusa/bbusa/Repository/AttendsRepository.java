package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttendsRepository extends JpaRepository<AttendsEntity, String> {

    @Query(value = "Select a.SID, a.CID, attend_date, attendance FROM Attends as a WHERE a.SID = :SID AND " +
            "a.CID = :CID" , nativeQuery = true)
    List<AttendsEntity> getClassAttends(int SID, int CID);

}