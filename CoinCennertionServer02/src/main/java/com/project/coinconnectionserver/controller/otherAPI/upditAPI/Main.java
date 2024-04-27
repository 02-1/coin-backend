//package com.project.coinconnectionserver.controller.otherAPI.upditAPI;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Main {
//    public static void main(String[] args) {
//        UpbitApiService upbitApiService = new UpbitApiService(new ObjectMapper());
//
//        // Specify the coin name you want to fetch data for
//        String coinName = "ETH";
//
//        // Call the getCandle method to fetch candle data for the specified coin
//        CandleData[] candleData = upbitApiService.getCandle(coinName);
//
//        if (candleData != null) {
//            System.out.println("Candle data for " + coinName + ":");
//            for (CandleData data : candleData) {
//                System.out.println("Trade Price: " + data.getTradePrice());
//            }
//        } else {
//            System.out.println("Failed to fetch candle data for " + coinName);
//        }
//    }
//}
