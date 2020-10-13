package com.charter.codingTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodingTestResponse {

    @JsonProperty("totalPurchased")
    private Integer totalPurchased = 0;
    @JsonProperty("totalRewards")
    private Integer totalRewards = 0;
    @JsonProperty("firstMonthPurchasedAmount")
    private Integer firstMonthPurchasedAmount = 0;
    @JsonProperty("firstMonthRewards")
    private Integer firstMonthRewards = 0;
    @JsonProperty("secondMonthPurchasedAmount")
    private Integer secondMonthPurchasedAmount = 0;
    @JsonProperty("secondMonthRewards")
    private Integer secondMonthRewards = 0;
    @JsonProperty("thirdMonthPurchasedAmount")
    private Integer thirdMonthPurchasedAmount = 0;
    @JsonProperty("thirdMonthRewards")
    private Integer thirdMonthRewards = 0;


    public Integer getTotalPurchased() {
        return totalPurchased;
    }

    public CodingTestResponse setTotalPurchased(Integer totalPurchased) {
        this.totalPurchased = totalPurchased;
        return this;
    }

    public Integer getFirstMonthPurchasedAmount() {
        return firstMonthPurchasedAmount;
    }

    public CodingTestResponse setFirstMonthPurchasedAmount(Integer firstMonthPurchasedAmount) {
        this.firstMonthPurchasedAmount = firstMonthPurchasedAmount;
        return this;
    }

    public Integer getSecondMonthPurchasedAmount() {
        return secondMonthPurchasedAmount;
    }

    public CodingTestResponse setSecondMonthPurchasedAmount(Integer secondMonthPurchasedAmount) {
        this.secondMonthPurchasedAmount = secondMonthPurchasedAmount;
        return this;
    }

    public Integer getThirdMonthPurchasedAmount() {
        return thirdMonthPurchasedAmount;
    }

    public CodingTestResponse setThirdMonthPurchasedAmount(Integer thirdMonthPurchasedAmount) {
        this.thirdMonthPurchasedAmount = thirdMonthPurchasedAmount;
        return this;
    }

    public Integer getFirstMonthRewards() {
        return firstMonthRewards;
    }

    public CodingTestResponse setFirstMonthRewards(Integer firstMonthRewards) {
        this.firstMonthRewards = firstMonthRewards;
        return this;
    }

    public Integer getSecondMonthRewards() {
        return secondMonthRewards;
    }

    public CodingTestResponse setSecondMonthRewards(Integer secondMonthRewards) {
        this.secondMonthRewards = secondMonthRewards;
        return this;
    }

    public Integer getThirdMonthRewards() {
        return thirdMonthRewards;
    }

    public CodingTestResponse setThirdMonthRewards(Integer thirdMonthRewards) {
        this.thirdMonthRewards = thirdMonthRewards;
        return this;
    }

    public Integer getTotalRewards() {
        return totalRewards;
    }

    public CodingTestResponse setTotalRewards(Integer totalRewards) {
        this.totalRewards = totalRewards;
        return this;
    }
}
