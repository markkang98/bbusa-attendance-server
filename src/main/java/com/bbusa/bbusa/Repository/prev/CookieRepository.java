package com.bbusa.bbusa.Repository.prev;

import com.bbusa.bbusa.Entity.CookieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<CookieEntity, String> {

    @Query(value = "SELECT * FROM cookie x WHERE x.cookie = :cookie", nativeQuery = true)
    CookieEntity findLoggedInUser(String cookie);

}
