package com.project.coinconnectionserver.persistence.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExchangeRateDTO
{
    private double exchangeRate;

    public ExchangeRateDTO(double exchangeRate)
    {
        this.exchangeRate = exchangeRate;
    }
}
