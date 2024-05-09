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
    private String coinDetail1;
    private String coinDetail2;
    private String coinDetail3;

    public CoinDTO(int coinId, String coinName, String coinSymbol, String imgUrl, String coinDetail1, String coinDetail2, String coinDetail3) {
        this.coinId = coinId;
        this.coinName = coinName;
        this.coinSymbol = coinSymbol;
        this.imgUrl = imgUrl;
        this.coinDetail1 = coinDetail1;
        this.coinDetail2 = coinDetail2;
        this.coinDetail3 = coinDetail3;
    }
}

