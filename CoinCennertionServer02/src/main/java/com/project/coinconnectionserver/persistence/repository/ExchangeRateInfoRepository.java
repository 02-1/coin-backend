package com.project.coinconnectionserver.persistence.repository;// ExchangeRateRepository.java
import com.project.coinconnectionserver.persistence.entity.ExchangeRateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateInfoRepository extends JpaRepository<ExchangeRateInfo, Integer> {
    // Insert Any Method
}
