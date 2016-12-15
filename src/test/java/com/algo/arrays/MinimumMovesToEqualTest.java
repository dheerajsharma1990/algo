package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumMovesToEqualTest {

    private int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        return Arrays.stream(nums)
                .map(num -> num - min)
                .sum();
    }

    private int min(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    private int max(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    @Test
    public void shouldFindMinimumCount() {
        assertThat(minMoves(new int[]{3, 1, 2}), is(3));
        assertThat(minMoves(new int[]{4, 2, 4, 2}), is(4));
        assertThat(minMoves(new int[]{4, -1, 0, 1}), is(8));
    }


}
