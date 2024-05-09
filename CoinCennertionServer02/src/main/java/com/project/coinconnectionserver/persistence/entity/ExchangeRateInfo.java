package com.project.coinconnectionserver.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExchangeRateInfo
{
    @Id
    private int rateId;
    
    private double exchangeRate;
}
