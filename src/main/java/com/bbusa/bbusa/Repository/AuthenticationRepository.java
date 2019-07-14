package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.AuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity, String> {
    @Query(value = "SELECT salt FROM authentication x WHERE x.user_id = :user_id", nativeQuery = true)
    byte [] getSalt(@Param("user_id")String user_id);

    @Query(value = "SELECT hashed_password FROM authentication x WHERE x.user_id = :user_id", nativeQuery = true)
    String getHashedPassword(@Param("user_id") String user_id);
}
