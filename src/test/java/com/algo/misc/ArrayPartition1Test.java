package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayPartition1Test {


    private int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> nums[i])
                .reduce((a, b) -> a + b)
                .get();

    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(arrayPairSum(new int[]{3, 1, 2, 4}), is(4));
        assertThat(arrayPairSum(new int[]{-1, 0}), is(-1));
        assertThat(arrayPairSum(new int[]{-1, -1, 0, 0}), is(-1));
    }
}
