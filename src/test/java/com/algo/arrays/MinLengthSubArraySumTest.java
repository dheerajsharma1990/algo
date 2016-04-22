package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinLengthSubArraySumTest {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int sumTillNow = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sumTillNow < s) {
                sumTillNow += nums[j];
                j++;
                continue;
            } else {
                while (sumTillNow >= s) {
                    min = Math.min(min, j - i);
                    sumTillNow -= nums[i];
                    i++;
                }
            }
        }
        while (sumTillNow >= s) {
            min = Math.min(min, j - i);
            sumTillNow -= nums[i];
            i++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    public void shouldGetMinLengthSubArray() {
        assertThat(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), is(2));
        assertThat(minSubArrayLen(2, new int[]{2}), is(1));
        assertThat(minSubArrayLen(2, new int[]{1}), is(0));
        assertThat(minSubArrayLen(3, new int[]{1, 2}), is(2));
        assertThat(minSubArrayLen(4, new int[]{2, 2, 2, 2}), is(2));
        assertThat(minSubArrayLen(4, new int[]{2, 2, 2, 4}), is(1));
        assertThat(minSubArrayLen(4, new int[]{2, 2, 4, 2}), is(1));
        assertThat(minSubArrayLen(4, new int[]{2, 2, 4, 2}), is(1));
    }
}
