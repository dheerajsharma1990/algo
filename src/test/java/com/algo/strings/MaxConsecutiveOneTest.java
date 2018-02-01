package com.algo.strings;

import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class MaxConsecutiveOneTest {

    private int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
                continue;
            }
            count++;
        }
        max = Math.max(count,max);
        return max;
    }

    @Test
    public void shouldGetMaxConsecutiveOne() {
        assertThat(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}), is(3));

    }
}
