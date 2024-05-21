package com.project.coinconnectionserver.controller.coin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCoin {
    private int id;
    private String img_link, ticker, name;

//    private static String toFormattedString(Double value) {
//        if (value >= 1000)
//        {
//            return String.format("%,.0f", value);
//        }
//        else if (value >= 100)
//        {
//            return String.format("%,.1f", value);
//        }
//        else if (value >= 10)
//        {
//            return String.format("%,.2f", value);
//        }
//        else
//        {
//            return String.format("%,.5f", value);
//        }
//    }

    public SimpleCoin(int id, String img_link, String ticker, String name) {

        this.id = id;
        this.img_link = img_link;
        this.ticker = ticker;
        this.name = name;
    }
}
