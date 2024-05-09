package com.project.coinconnectionserver.controller.otherAPI.binanceAPI;

import com.project.coinconnectionserver.controller.ExchangeRateCrawler;
import com.project.coinconnectionserver.service.ExchangeRateService;

import java.io.IOException;
public class BinanceCryptoHandler {
    private final BinanceApiService api = new BinanceApiService();
    private double exchangeRate = 0.0;

    public BinanceCryptoHandler(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getTradePrice(String tickerName) {
        try {
            double usdtprice = Double.parseDouble(api.getCurrentPrice(tickerName + "USDT"));
            return usdtprice * exchangeRate;
        } catch (IOException | InterruptedException ignored) {
            return 0.0;
        }
    }
}