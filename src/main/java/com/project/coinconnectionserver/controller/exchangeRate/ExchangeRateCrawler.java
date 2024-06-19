package com.project.coinconnectionserver.controller.exchangeRate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ExchangeRateCrawler {
    public static double getExchangeRate() {
        String url =
                "https://www.kita.net/cmmrcInfo/ehgtGnrlzInfo/rltmEhgt.do";

        try {
            Document doc = Jsoup.connect(url).get();

            Element exchangeRateElement = doc.select("body > div.ct.page-exchange > div.container > div:nth-child(2) > div.table-wrap-outline.mt-3 > table > tbody > tr:nth-child(1) > td:nth-child(2)").first();

            double result = Double.parseDouble(exchangeRateElement.text().replace(",", "").split(" ")[0]);
//            System.out.println(result);
            return result;

        } catch (Exception ignored) {
            return 0;
        }
    }
}
