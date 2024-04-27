package com.project.coinconnectionserver.persistence.repository;

import com.project.coinconnectionserver.persistence.entity.CoinInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends JpaRepository<CoinInfo, Long> {
    // Insert Any Method
}