package com.project.coinconnectionserver.controller;

import com.project.coinconnectionserver.service.ExchangeRateService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExchangeRateAspect {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateAspect(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Before("execution(* com.project.coinconnectionserver.controller.*.*(..))")
    public void updateExchangeRateBeforeMethodExecution() {
        exchangeRateService.refreshExchangeRate();
    }
}
