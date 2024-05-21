package com.project.coinconnectionserver.controller.coin;

import com.project.coinconnectionserver.controller.coin.SimpleCoin;
import com.project.coinconnectionserver.persistence.DTO.CoinDTO;
import com.project.coinconnectionserver.persistence.DTO.CoinDetailDTO;
import com.project.coinconnectionserver.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinController {

    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/coin-list")
    public List<SimpleCoin> getAllCoinSimpleInfo() {
        return coinService.findAllCoinsSimpleData();
    }

    @GetMapping("/coin-detail")
    public CoinDetailDTO getCoinDetailBySymbol(@RequestParam String symbol) {
        return coinService.findCoinDataBySymbol(symbol);
    }
}
