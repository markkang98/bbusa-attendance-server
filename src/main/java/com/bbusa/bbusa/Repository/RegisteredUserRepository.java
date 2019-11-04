package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, String> {

}