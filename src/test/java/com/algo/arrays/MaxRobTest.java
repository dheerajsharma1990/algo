package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxRobTest {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int firstMax = nums[0];
        int secondMax = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int myMax = Math.max(nums[i] + firstMax, secondMax);
            firstMax = secondMax;
            secondMax = myMax;
        }
        return Math.max(firstMax, secondMax);
    }

    @Test
    public void shouldRobMaximumAmount() {
        //then
        assertThat(rob(new int[]{1}), is(1));
        assertThat(rob(new int[]{1, 0}), is(1));
        assertThat(rob(new int[]{1, 2, 4, 1}), is(5));
        assertThat(rob(new int[]{1, 2, 4, 5}), is(7));
        assertThat(rob(new int[]{2, 1, 1, 2}), is(4));
    }
}
