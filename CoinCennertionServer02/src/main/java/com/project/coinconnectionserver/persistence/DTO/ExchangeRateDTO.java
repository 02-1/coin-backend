package com.project.coinconnectionserver.persistence.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExchangeRateDTO
{
    private int rateId;
    private double exchangeRate;
    
    public ExchangeRateDTO(int rateId, double exchangeRate)
    {
        this.rateId = rateId;
        this.exchangeRate = exchangeRate;
    }
}
