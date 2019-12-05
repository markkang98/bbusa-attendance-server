package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, String> {
    @Query(value = "SELECT salt FROM RegisteredUser x WHERE x.email = :user_id", nativeQuery = true)
    byte [] getSalt(@Param("user_id")String user_id);

    @Query(value = "SELECT hashed_password FROM RegisteredUser x WHERE x.email = :user_id", nativeQuery = true)
    String getHashedPassword(@Param("user_id") String user_id);

    @Query(value = "SELECT first_name FROM RegisteredUser WHERE RegisteredUser.email = :instructor_email", nativeQuery = true)
    String getFirstName(@Param("instructor_email") String instructor_email);

    @Query(value = "SELECT last_name FROM RegisteredUser WHERE RegisteredUser.email = :instructor_email", nativeQuery = true)
    String getLastName(@Param("instructor_email") String instructor_email);


    @Query(value = "SELECT r.email, r.first_name, r.last_name, r.password, r.hashed_password, r.salt FROM RegisteredUser r, Takes t, Student s, Classes c WHERE " +
            "c.CID = :CID AND t.CID = :CID AND s.SID = t.SID AND s.student_email = r.email", nativeQuery = true)
    List<RegisteredUserEntity> listOfStudentsTakingClass(@Param("CID") int CID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RegisteredUser SET RegisteredUser.email = :email, RegisteredUser.first_name = :firstName, RegisteredUser.last_name = :lastName WHERE RegisteredUser.email = :original_email", nativeQuery = true)
    void update(String email, String firstName, String lastName, String original_email);
}