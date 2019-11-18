package com.bbusa.bbusa.Repository;
import com.bbusa.bbusa.Entity.TakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesRepository extends JpaRepository<TakesEntity, String> {
    @Query(value =
            "Select a.SID, a.CID, start_date " +
            "FROM Takes as a, Student as s " +
            "WHERE a.SID = s.SID", nativeQuery = true)
    List<AttendsEntity> getStudentTakes(@Param("SID") int SID);
}