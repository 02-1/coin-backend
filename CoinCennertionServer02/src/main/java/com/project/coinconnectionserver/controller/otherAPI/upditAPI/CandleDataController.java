//package com.project.coinconnectionserver.controller.otherAPI.upditAPI;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CandleDataController {
//
//    private final UpbitApiService upbitApiService;
//
//    @Autowired
//    public CandleDataController(UpbitApiService upbitApiService) {
//        this.upbitApiService = upbitApiService;
//    }
//
//    @GetMapping("/candle-data")
//    public CandleData[] getCandle(@RequestParam String market) {
//        // Fetch candle data for the specified market
//        CandleData[] candleData = upbitApiService.getCandle(market);
//        if (candleData != null) {
//            return candleData;
//        } else {
//            // Return an empty array if there's an error
//            return new CandleData[0];
//        }
//    }
//}
