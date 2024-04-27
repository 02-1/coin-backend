package com.project.coinconnectionserver.controller;

import com.project.coinconnectionserver.controller.otherAPI.binanceAPI.BinanceCryptoHandler;
import com.project.coinconnectionserver.controller.otherAPI.upditAPI.UpbitCryptoHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCoin {
    private int id;
    private String img_link, ticker, name, price_upbit, price_binance, price_gap;
    private double gap_percent;

    private static String toFormattedString(Double value) {
        if (value >= 1000)
        {
            return String.format("%,.0f", value);
        }
        else if (value >= 100)
        {
            return String.format("%,.1f", value);
        }
        else if (value >= 10)
        {
            return String.format("%,.2f", value);
        }
        else
        {
            return String.format("%,.5f", value);
        }
    }

    public SimpleCoin(int id, String img_link, String ticker, String name) {
        UpbitCryptoHandler upbit = new UpbitCryptoHandler();
        BinanceCryptoHandler binance = new BinanceCryptoHandler();

        double priceUp = upbit.getTradePrice(ticker), priceBi = binance.getTradePrice(ticker);
        double gap = priceUp - priceBi;

        this.id = id;
        this.img_link = img_link;
        this.ticker = ticker;
        this.name = name;
        this.price_upbit = toFormattedString(priceUp);
        this.price_binance = toFormattedString(priceBi);
        this.price_gap = toFormattedString(gap);
        this.gap_percent = (gap / priceUp) * 100;
    }
}
