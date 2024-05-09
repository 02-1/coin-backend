package com.project.coinconnectionserver.service;

import com.project.coinconnectionserver.controller.ExchangeRateCrawler;
import com.project.coinconnectionserver.persistence.entity.ExchangeRateInfo;
import com.project.coinconnectionserver.persistence.repository.ExchangeRateInfoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


@Service
public class ExchangeRateService {
    private final ExchangeRateInfoRepository exchangeRateInfoRepository;

    @Autowired
    public ExchangeRateService(ExchangeRateInfoRepository exchangeRateInfoRepository) {
        this.exchangeRateInfoRepository = exchangeRateInfoRepository;
    }

    @Transactional
    public void refreshExchangeRate() {
        // 크롤링한 환율 정보 가져오기
        double crawledRate = ExchangeRateCrawler.getExchangeRate();

        // 데이터베이스에서 rate_id가 1인 환율 정보 조회
        ExchangeRateInfo exchangeRateInfo = exchangeRateInfoRepository.findById(1).orElse(null);
        if (exchangeRateInfo != null) {
            // 조회한 환율 정보의 환율 값을 크롤링한 환율로 업데이트
            exchangeRateInfo.setExchangeRate(crawledRate);
            exchangeRateInfoRepository.save(exchangeRateInfo);
        }
    }

    public List<ExchangeRateInfo> findAllExchangeRates() {
        return exchangeRateInfoRepository.findAll();
    }
}
