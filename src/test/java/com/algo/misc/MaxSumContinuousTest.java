package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxSumContinuousTest {

    public int maxSubArray(final List<Integer> a) {
        int maxSum = a.get(0);
        int currSum = maxSum;
        for (int i = 1; i < a.size(); i++) {
            if ((currSum + a.get(i)) > a.get(i)) {
                currSum += a.get(i);
            } else {
                currSum = a.get(i);
            }
            maxSum = currSum > maxSum ? currSum : maxSum;
        }
        return maxSum;
    }

    @Test
    public void shouldGetMaxSumForSingleElementArray() {
        //then
        assertThat(maxSubArray(Arrays.asList(-1)), is(-1));
    }

    @Test
    public void shouldGetMaxSumForAll0ElementsArray() {
        //then
        assertThat(maxSubArray(Arrays.asList(0, 0, 0, 0)), is(0));
    }

    @Test
    public void shouldGetMaxSumForDifferentArray() {
        //then
        assertThat(maxSubArray(Arrays.asList(1, 2, 5, -7, 2, 3)), is(8));
        assertThat(maxSubArray(Arrays.asList(1, 2, -1, 1, 1, 1)), is(5));
        assertThat(maxSubArray(Arrays.asList(1, 2, -1, 3, 0)), is(5));
    }

}
