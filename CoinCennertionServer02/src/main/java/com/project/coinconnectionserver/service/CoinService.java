package com.project.coinconnectionserver.service;

import com.project.coinconnectionserver.controller.SimpleCoin;
import com.project.coinconnectionserver.persistence.DTO.CoinDTO;
import com.project.coinconnectionserver.persistence.entity.CoinInfo;
import com.project.coinconnectionserver.persistence.entity.ExchangeRateInfo;
import com.project.coinconnectionserver.persistence.repository.CoinRepository;
import com.project.coinconnectionserver.persistence.repository.ExchangeRateInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinService {

    private final CoinRepository coinRepository;
    private final ExchangeRateInfoRepository exchangeRateInfoRepository;

    @Autowired
    public CoinService(CoinRepository coinRepository, ExchangeRateInfoRepository exchangeRateInfoRepository) {
        this.coinRepository = coinRepository;
        this.exchangeRateInfoRepository = exchangeRateInfoRepository;
    }

    public List<SimpleCoin> findAllCoinsSimpleData() {
        List<CoinInfo> coinInfoList = coinRepository.findAll();
        List<ExchangeRateInfo> exchangeRateInfoList = exchangeRateInfoRepository.findAll();

        List<SimpleCoin> simpleCoins = new ArrayList<>();

        for (CoinInfo coinInfo : coinInfoList) {
            for (ExchangeRateInfo exchangeRateInfo : exchangeRateInfoList) {
                SimpleCoin simpleCoin = convertEntityToSimpleCoin(coinInfo, exchangeRateInfo);
                if (simpleCoin != null) {
                    simpleCoins.add(simpleCoin);
                }
            }
        }

        return simpleCoins;
    }

//    public List<SimpleCoin> findAllCoinsSimpleData() {
//        List<CoinInfo> coinInfoList = coinRepository.findAll();
//        List<ExchangeRateInfo> exchangeRateInfoList = exchangeRateInfoRepository.findAll();
//
//        return coinInfoList.stream()
//                .map(coinInfo -> convertEntityToSimpleCoin(coinInfo, (ExchangeRateInfo) exchangeRateInfoList))
//                .collect(Collectors.toList());
//    }

    private SimpleCoin convertEntityToSimpleCoin(CoinInfo coinInfo, ExchangeRateInfo exchangeRateInfo) {
        if (coinInfo == null || exchangeRateInfo == null) {
            return null;
        }

        return new SimpleCoin(
                coinInfo.getCoinId(),
                coinInfo.getImgUrl(),
                coinInfo.getCoinSymbol(),
                coinInfo.getCoinName(),
                exchangeRateInfo.getExchangeRate()
        );
    }

    private CoinDTO convertEntityToDTO(CoinInfo coinInfo) {
        return new CoinDTO(
                Math.toIntExact(coinInfo.getCoinId()),
                coinInfo.getCoinName(),
                coinInfo.getCoinSymbol(),
                coinInfo.getImgUrl(),
                coinInfo.getCoinDetail1(),
                coinInfo.getCoinDetail2(),
                coinInfo.getCoinDetail3()
        );
    }
}
