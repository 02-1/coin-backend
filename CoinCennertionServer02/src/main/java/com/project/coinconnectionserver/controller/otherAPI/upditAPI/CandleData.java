package com.project.coinconnectionserver.controller.otherAPI.upditAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandleData {

    @JsonProperty("trade_price")
    private double tradePrice;
}
