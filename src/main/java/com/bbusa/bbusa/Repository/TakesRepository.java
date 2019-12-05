package com.bbusa.bbusa.Repository;
import com.bbusa.bbusa.Entity.AttendsEntity;
import com.bbusa.bbusa.Entity.TakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TakesRepository extends JpaRepository<TakesEntity, String> {
    @Query(value =
            "Select a.SID, a.CID, start_date " +
            "FROM Takes as a, Student as s " +
            "WHERE a.SID = s.SID", nativeQuery = true)
    List<AttendsEntity> getStudentTakes(@Param("SID") int SID);

    @Query(value = "SELECT * FROM Takes WHERE Takes.verified = 0 AND Takes.CID = :CID", nativeQuery = true)
    List<TakesEntity> getUnverifiedRequests(@Param("CID") int CID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Takes SET Takes.verified = 1 WHERE Takes.SID = :SID AND Takes.CID = :CID", nativeQuery = true)
    void grantRequest(int SID, int CID);

}