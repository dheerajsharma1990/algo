package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LISTest {
    public int lis(final List<Integer> a) {
        int max[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (a.get(j) < a.get(i)) {
                    maxValue = maxValue > max[j] ? maxValue : max[j];
                }
            }
            max[i] = maxValue + 1;
        }
        int maxValue = 0;
        for (int m : max) {
            maxValue = m > maxValue ? m : maxValue;
        }
        return maxValue;
    }

    @Test
    public void shouldGetMaxLIS() {
        assertThat(lis(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)), is(6));
        assertThat(lis(Arrays.asList(1, 2, 3, 4)), is(4));
        assertThat(lis(Arrays.asList(1)), is(1));
        assertThat(lis(Arrays.asList(4, 3, 2, 1)), is(1));
    }
}
