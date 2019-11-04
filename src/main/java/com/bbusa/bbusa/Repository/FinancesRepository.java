package com.bbusa.bbusa.Repository;
import com.bbusa.bbusa.Entity.FinancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancesRepository extends JpaRepository<FinancesEntity, String> {


}