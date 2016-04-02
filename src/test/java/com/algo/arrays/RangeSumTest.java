package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RangeSumTest {
    class NumArray {
        int[] startCumulative;

        public NumArray(int[] nums) {
            startCumulative = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                startCumulative[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return startCumulative[j];
            } else {
                return startCumulative[j] - startCumulative[i - 1];
            }
        }
    }

    @Test
    public void shouldTestVariousScenarios() {
        //given
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        //then
        assertThat(numArray.sumRange(0, 2), is(1));
        assertThat(numArray.sumRange(2, 5), is(-1));
        assertThat(numArray.sumRange(0, 5), is(-3));

    }
}
