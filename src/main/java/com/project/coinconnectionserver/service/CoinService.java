package com.project.coinconnectionserver.service;

import com.project.coinconnectionserver.controller.coin.SimpleCoin;
import com.project.coinconnectionserver.controller.otherAPI.coinnewsAPI.CoinNewsApiHandler;
import com.project.coinconnectionserver.persistence.DTO.CoinDTO;
import com.project.coinconnectionserver.persistence.DTO.CoinDetailDTO;
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

    @Autowired
    public CoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public List<SimpleCoin> findAllCoinsSimpleData() {
        List<CoinInfo> coinInfoList = coinRepository.findAll();

        List<SimpleCoin> simpleCoins = new ArrayList<>();

        for (CoinInfo coinInfo : coinInfoList) {
            SimpleCoin simpleCoin = convertEntityToSimpleCoin(coinInfo);
            if (simpleCoin != null) {
                simpleCoins.add(simpleCoin);
            }
        }

        return simpleCoins;
    }

    private SimpleCoin convertEntityToSimpleCoin(CoinInfo coinInfo) {
        if (coinInfo == null) {
            return null;
        }

        return new SimpleCoin(
                coinInfo.getCoinId(),
                coinInfo.getImgUrl(),
                coinInfo.getCoinSymbol(),
                coinInfo.getCoinName(),
                coinInfo.getViewCount()
        );
    }

    public CoinDetailDTO findCoinDataBySymbol(String coinSymbol) {
        CoinInfo coinInfo = coinRepository.findByCoinSymbol(coinSymbol)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Coin not found"));

        return convertEntityToDetailDTO(coinInfo);
    }

    public boolean CoinViewBySymbol(String coinSymbol) {
        CoinInfo coinInfo = coinRepository.findByCoinSymbol(coinSymbol)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Coin not found"));

        coinInfo.setViewCount(coinInfo.getViewCount() + 1);

        coinRepository.save(coinInfo);

        return true;
    }



    public String findCoinNewsBySymbol(String coinSymbol, String offset, String limit) {
//        CoinInfo coinInfo = coinRepository.findByCoinSymbol(coinSymbol)
//                .stream()
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Coin not found"));

        CoinNewsApiHandler newsHandler = new CoinNewsApiHandler(coinSymbol, offset, limit);

        return newsHandler.getNews();
    }

    private CoinDTO convertEntityToDTO(CoinInfo coinInfo) {
        return new CoinDTO(
                Math.toIntExact(coinInfo.getCoinId()),
                coinInfo.getCoinName(),
                coinInfo.getCoinSymbol(),
                coinInfo.getImgUrl(),
                coinInfo.getCoinDetail()
        );
    }

    private CoinDetailDTO convertEntityToDetailDTO(CoinInfo coinInfo) {
        return new CoinDetailDTO(
                coinInfo.getCoinName(),
                coinInfo.getCoinSymbol(),
                coinInfo.getCoinDetail()
        );
    }
}
