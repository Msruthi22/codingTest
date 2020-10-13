package com.charter.codingTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class CodingTestVO {

    @JsonProperty("purchasedAmount")
    private Integer purchasedAmount;
    @JsonProperty("purchasedDate")
    private Date purchasedDate;

    /**
     * @return the purchasedAmount
     */
    public Integer getPurchasedAmount() { return purchasedAmount; }

    /**
     * @param purchasedAmount the purchasedAmount to set
     */
    public void setPurchasedAmount(Integer purchasedAmount) { this.purchasedAmount = purchasedAmount; }

    /**
     * @return the purchasedDate
     */
    public Date getPurchasedDate() { return purchasedDate; }

    /**
     * @param purchasedDate the purchasedDate to set
     */
    public void setPurchasedDate(Date purchasedDate) { this.purchasedDate = purchasedDate; }
}
