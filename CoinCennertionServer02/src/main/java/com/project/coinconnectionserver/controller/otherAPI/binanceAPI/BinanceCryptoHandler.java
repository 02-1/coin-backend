package com.project.coinconnectionserver.controller.otherAPI.binanceAPI;

import com.project.coinconnectionserver.controller.ExchangeRateCrawler;

public class BinanceCryptoHandler {
    BinanceApiService api = new BinanceApiService();

    public double getTradePrice(String tickerName) {

        try {
            double usdtprice = Double.parseDouble(api.getCurrentPrice(tickerName + "USDT"));
            double rate = ExchangeRateCrawler.getExchangeRate();

            return usdtprice * rate;

        }
        catch (Exception ignored) {}

        return 0.0;
    }
}
