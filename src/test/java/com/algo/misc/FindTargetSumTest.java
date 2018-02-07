package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindTargetSumTest {

    private int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        int[][] ans = new int[nums.length + 1][2001];
        ans[0][1000] = 1;
        for (int j = 1; j <= nums.length; j++) {
            for (int i = -1000; i < 1001; i++) {
                int num = nums[j - 1];
                ans[j][i + 1000] = ans[j - 1][1000 + i - num < 0 ? 0 : 1000 + i - num] + ans[j - 1][1000 + i + num > 2000 ? 0 : 1000 + i + num];
            }
        }
        return ans[nums.length][1000 + S];
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3), is(5));
        assertThat(findTargetSumWays(new int[]{4, 1, 6, 0, 3, 1, 10, 12, 3, 7}, 5), is(42));
        assertThat(findTargetSumWays(new int[]{1, 2, 7, 9, 981}, 1000000000), is(0));
        assertThat(findTargetSumWays(new int[]{2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53}, 2147483647), is(0));

    }
}
