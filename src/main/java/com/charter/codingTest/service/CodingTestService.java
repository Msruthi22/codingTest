package com.charter.codingTest.service;

import com.charter.codingTest.exception.CodingTestException;
import com.charter.codingTest.model.CodingTestResponse;
import com.charter.codingTest.model.CodingTestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CodingTestService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * calculate the reward points earned for customer per month and total.
     * @param purchasedList {@link CodingTestVO}
     * @return Integer
     */
    public CodingTestResponse calculateRewards(final List<CodingTestVO> purchasedList) throws CodingTestException {
        Integer totalPurchased = 0;
        Integer firstMonthPurchasedAmount = 0;
        Integer secondMonthPurchasedAmount = 0;
        Integer thirdMonthPurchasedAmount = 0;
        Integer totalRewards = 0;
        Integer firstMonthRewards = 0;
        Integer secondMonthRewards = 0;
        Integer thirdMonthRewards = 0;
        if (CollectionUtils.isEmpty(purchasedList))
            throw new CodingTestException("Zero items purchased");
        else {
            Calendar currentDateBefore3Months = Calendar.getInstance();
            currentDateBefore3Months.add(Calendar.MONTH, -3);
            Calendar currentDateBefore2Months = Calendar.getInstance();
            currentDateBefore2Months.add(Calendar.MONTH, -2);
            Calendar currentDateBefore1Months = Calendar.getInstance();
            currentDateBefore1Months.add(Calendar.MONTH, -1);
            Calendar currentDate = Calendar.getInstance();


            for (CodingTestVO list : purchasedList) {
                Date purchasedDate = list.getPurchasedDate();
                Integer rewards = this.getRewards(list.getPurchasedAmount());

                // condition check for purchased item is in 3 month period
                if (purchasedDate.after(currentDateBefore3Months.getTime())) {
                    totalPurchased = totalPurchased + list.getPurchasedAmount();
                    totalRewards = totalRewards + rewards;
                }

                // In 1st month range
                if (purchasedDate.before(currentDate.getTime()) &&
                    purchasedDate.after(currentDateBefore1Months.getTime())) {
                    firstMonthPurchasedAmount = firstMonthPurchasedAmount + list.getPurchasedAmount();
                    firstMonthRewards = firstMonthRewards + rewards;
                }

                // In 2nd month range
                if (purchasedDate.before(currentDateBefore1Months.getTime()) &&
                    purchasedDate.after(currentDateBefore2Months.getTime())) {
                    secondMonthPurchasedAmount = secondMonthPurchasedAmount + list.getPurchasedAmount();
                    secondMonthRewards = secondMonthRewards + rewards;
                }

                // In 3rd month range
                if (purchasedDate.before(currentDateBefore2Months.getTime()) &&
                    purchasedDate.after(currentDateBefore3Months.getTime())) {
                    thirdMonthPurchasedAmount = thirdMonthPurchasedAmount + list.getPurchasedAmount();
                    thirdMonthRewards = thirdMonthRewards + rewards;
                }
            }
        }
        log.info("Total purchased {} ", totalPurchased);
        log.info("Total rewards {} ", totalRewards);

        return new CodingTestResponse()
            .setFirstMonthPurchasedAmount(firstMonthPurchasedAmount)
            .setSecondMonthPurchasedAmount(secondMonthPurchasedAmount)
            .setThirdMonthPurchasedAmount(thirdMonthPurchasedAmount)
            .setTotalPurchased(totalPurchased)
            .setTotalRewards(totalRewards)
            .setFirstMonthRewards(firstMonthRewards)
            .setSecondMonthRewards(secondMonthRewards)
            .setThirdMonthRewards(thirdMonthRewards);
    }

    /**
     * get rewards points.
     * @param amount Integer
     * @return Integer
     */
    private Integer getRewards(final Integer amount) {
        Integer rewards = 0;
        if (amount > 100) {
            Integer possibleRewards = amount - 100;
            rewards = possibleRewards * 2;
            rewards = rewards + 50;
        } else if (amount >= 50 && amount <= 100)
            rewards = amount - 50;

        return rewards;
    }
}
