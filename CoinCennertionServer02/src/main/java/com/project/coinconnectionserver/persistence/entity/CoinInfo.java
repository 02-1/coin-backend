package com.project.coinconnectionserver.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CoinInfo
{
    @Id
    private int coinId;

    private String coinName;
    private String coinSymbol;
    private String imgUrl;

    @Lob
    private String coinDetail1;
    @Lob
    private String coinDetail2;
    @Lob
    private String coinDetail3;
}

