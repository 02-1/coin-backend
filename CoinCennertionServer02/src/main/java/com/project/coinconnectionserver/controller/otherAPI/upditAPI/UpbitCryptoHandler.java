package com.project.coinconnectionserver.controller.otherAPI.upditAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpbitCryptoHandler {
    UpbitApiService api = new UpbitApiService(new ObjectMapper());

    public double getTradePrice(String tickerName) {
        CandleData[] candleData = api.getCandle(tickerName);

        if (candleData != null) {
            for (CandleData data : candleData) {
                return data.getTradePrice();
            }
        } else {
            System.out.println("Failed to fetch candle data for " + tickerName);
            return 0.0;
        }

        return 0.0;
    }
}
