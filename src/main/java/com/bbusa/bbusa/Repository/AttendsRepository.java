package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AttendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendsRepository extends JpaRepository<AttendsEntity, String> {

    @Query(value = "SELECT * FROM innodb.Attends" , nativeQuery = true)
    List<AttendsEntity> getAllAttends();
}