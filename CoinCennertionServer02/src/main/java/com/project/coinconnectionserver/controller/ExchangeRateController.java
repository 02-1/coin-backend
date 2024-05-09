package com.project.coinconnectionserver.controller;// ExchangeRateController.java
import com.project.coinconnectionserver.persistence.entity.ExchangeRateInfo;
import com.project.coinconnectionserver.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {
    private final ExchangeRateService exchangeService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping
    public List<ExchangeRateInfo> getAllExchangeRates() {
        return exchangeService.findAllExchangeRates();
    }
}
