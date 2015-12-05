package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxProfitTest {
    public int maxProfit(final List<Integer> a) {
        if (a.size() == 0) {
            return 0;
        }
        int max = 0;
        int currMax = 0;
        int lastMin = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > a.get(i - 1)) {
                currMax = a.get(i) - lastMin;
            } else {
                max += currMax;
                currMax = 0;
                lastMin = a.get(i);
            }
        }
        return max + currMax;
    }

    @Test
    public void shouldTestVariousScenariosAndGetMaxProfit() {
        assertThat(maxProfit(Arrays.asList(1, 2, 3)), is(2));
        assertThat(maxProfit(Arrays.asList(4, 2, 5, 1, 7)), is(9));
        assertThat(maxProfit(Arrays.asList(1, 2)), is(1));
        assertThat(maxProfit(Arrays.asList(2, 1)), is(0));
        assertThat(maxProfit(Arrays.asList(1, 2, 3, 4, 5)), is(4));
        assertThat(maxProfit(Arrays.asList(5, 4, 3, 2, 1)), is(0));
        assertThat(maxProfit(Arrays.asList(1, 2, 3, 2, 1)), is(2));
        assertThat(maxProfit(Arrays.asList(1, 2, 3, 1, 2)), is(3));
    }
}
