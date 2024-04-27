package com.project.coinconnectionserver.controller.otherAPI.binanceAPI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class BinanceApiService {
    public String getCurrentPrice(String symbol) throws IOException, InterruptedException {

        String url = "https://api.binance.com/api/v3/ticker/price?symbol=" + symbol;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String result = "0.0";

        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            PriceData priceData = objectMapper.readValue(response.body(), PriceData.class);

            result = priceData.getPrice();
        }

        return result;
    }
}