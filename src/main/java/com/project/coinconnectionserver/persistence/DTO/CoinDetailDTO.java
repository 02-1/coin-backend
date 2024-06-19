package com.project.coinconnectionserver.persistence.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CoinDetailDTO
{
    private String ticker;
    private String name;
    private String detail;

    public CoinDetailDTO(String coinName, String coinSymbol, String coinDetail) {
        this.name = coinName;
        this.ticker = coinSymbol;
        this.detail = coinDetail;
    }
}
