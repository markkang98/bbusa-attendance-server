package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.TeachesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachesRepository extends JpaRepository<TeachesEntity, String> {

}