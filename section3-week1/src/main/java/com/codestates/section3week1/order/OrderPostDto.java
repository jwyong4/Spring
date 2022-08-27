package com.codestates.section3week1.order;

import javax.validation.constraints.*;

public class OrderPostDto {
    @Positive
    private long memberId;

    @Positive
    private long coffeeId;

    public long getMemberId() {
        return memberId;
    }

    public long getCoffeeId() {
        return coffeeId;
    }
}
