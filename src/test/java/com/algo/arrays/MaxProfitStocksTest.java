package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxProfitStocksTest {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0, j = 0;
        while (j < prices.length) {
            if (((j + 1) < prices.length) && prices[j] < prices[j + 1]) {
                j++;
            } else {
                profit += (prices[j] - prices[i]);
                j++;
                i = j;
            }
        }
        return profit;
    }

    @Test
    public void shouldTestMaxProfit() {
        assertThat(maxProfit(new int[]{2, 5, 1, 4, 3, 6}), is(9));
        assertThat(maxProfit(new int[]{6, 5, 4, 3}), is(0));
        assertThat(maxProfit(new int[]{6, 3, 1, 0, 3, 8}), is(8));
        assertThat(maxProfit(new int[]{1, 2, 3, 4, 5}), is(4));
        assertThat(maxProfit(new int[]{1, 1, 1}), is(0));
        assertThat(maxProfit(new int[]{0, 1, 2, 3, 2, 1, 0}), is(3));
        assertThat(maxProfit(new int[]{3, 2, 1, 2, 1}), is(1));
    }
}
