package com.project.coinconnectionserver.service;

import com.project.coinconnectionserver.controller.SimpleCoin;
import com.project.coinconnectionserver.persistence.DTO.CoinDTO;
import com.project.coinconnectionserver.persistence.entity.CoinInfo;
import com.project.coinconnectionserver.persistence.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return coinRepository.findAll().stream().map(this::convertEntityToSimpleCoin).collect(Collectors.toList());
    }

    public List<CoinDTO> findAllCoins() {
        return coinRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private SimpleCoin convertEntityToSimpleCoin(CoinInfo coinInfo) {
        return new SimpleCoin(
                coinInfo.getCoinId(),
                coinInfo.getImgUrl(),
                coinInfo.getCoinSymbol(),
                coinInfo.getCoinName()
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
