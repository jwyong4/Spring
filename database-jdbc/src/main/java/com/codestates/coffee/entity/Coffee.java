package com.codestates.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Coffee {
    @Id // COFFEE 테이블과 매핑
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;
}
