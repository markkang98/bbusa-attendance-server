package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, String> {
    @Query(value = "SELECT salt FROM RegisteredUser x WHERE x.email = :user_id", nativeQuery = true)
    byte [] getSalt(@Param("user_id")String user_id);

    @Query(value = "SELECT hashed_password FROM RegisteredUser x WHERE x.email = :user_id", nativeQuery = true)
    String getHashedPassword(@Param("user_id") String user_id);
}