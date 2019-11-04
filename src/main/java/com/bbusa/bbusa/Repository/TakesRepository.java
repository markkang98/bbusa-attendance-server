package com.bbusa.bbusa.Repository;
import com.bbusa.bbusa.Entity.TakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesRepository extends JpaRepository<TakesEntity, String> {

}