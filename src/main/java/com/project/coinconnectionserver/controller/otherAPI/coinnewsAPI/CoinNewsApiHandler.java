package com.project.coinconnectionserver.controller.otherAPI.coinnewsAPI;

public class CoinNewsApiHandler {
    String symbol, offset, limit;
    private final CoinNewsApiService api;

    public CoinNewsApiHandler(String symbol, String offset, String limit) {
        this.symbol = symbol;
        this.offset = offset;
        this.limit = limit;

        api = new CoinNewsApiService(symbol, offset, limit);
    }

    public String getNews()
    {
        return api.getNewsList();
    }


}
