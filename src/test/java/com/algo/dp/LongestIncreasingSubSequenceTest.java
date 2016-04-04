package com.algo.dp;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LongestIncreasingSubSequenceTest {

    public int lengthOfLIS(int[] nums) {
        int[] max = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxTillNow = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxTillNow = maxTillNow > max[j] ? maxTillNow : max[j];
                }
            }
            max[i] = maxTillNow + 1;
            ans = ans > max[i] ? ans : max[i];
        }
        return ans;
    }


    @Test
    public void shouldTestForVariousSequences() {
        assertThat(lengthOfLIS(new int[]{1, 2, 3, 4, 5}), is(5));
        assertThat(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), is(4));
        assertThat(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}), is(6));
        assertThat(lengthOfLIS(new int[]{6, 5, 4, 3, 2, 1}), is(1));
        assertThat(lengthOfLIS(new int[]{1}), is(1));
        assertThat(lengthOfLIS(new int[]{}), is(0));
    }
}
