package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.TeachesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachesRepository extends JpaRepository<TeachesEntity, String> {
    @Query(value =
            "Select a.IID, a.CID, start_date " +
                    "FROM Teaches as a, Instructor as i " +
                    "WHERE a.IID = i.IID", nativeQuery = true)
    List<AttendsEntity> getInstructorTeaches(@Param("IID") int IID);
}