package com.project.coinconnectionserver.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ExchangeRateCrawler {
    public static double getExchangeRate() {
        String url =
                "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=exchangeRate";

        try {
            Document doc = Jsoup.connect(url).get();

            Element exchangeRateElement = doc.select("#main_pack > section.sc_new.cs_nexchangerate > div.api_subject_bx._exchange_rate_banks_official > div.exchange_bx > div.sct_stock_list > div > ul.list_item._panel > li:nth-child(1) > a > dl > dd > span.spt_con.up > strong").first();

            return Double.parseDouble(exchangeRateElement.text().replace(",", ""));

        } catch (Exception ignored) {
            return 0;
        }
    }
}
