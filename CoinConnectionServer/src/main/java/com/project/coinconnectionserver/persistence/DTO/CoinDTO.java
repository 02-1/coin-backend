package com.project.coinconnectionserver.persistence.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CoinDTO
{
    private int coinId;
    private String coinName;
    private String coinSymbol;
    private String imgUrl;
    private String coinDetail;

    public CoinDTO(int coinId, String coinName, String coinSymbol, String imgUrl, String coinDetail) {
        this.coinId = coinId;
        this.coinName = coinName;
        this.coinSymbol = coinSymbol;
        this.imgUrl = imgUrl;
        this.coinDetail = coinDetail;
    }
}

