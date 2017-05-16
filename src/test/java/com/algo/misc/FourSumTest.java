package com.algo.misc;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FourSumTest {

    private int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                total += count.getOrDefault(-1 * (c + d), 0);
            }
        }
        return total;
    }

    @Test
    public void shouldCountNumberOfFourSum() {
        assertThat(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}), is(2));
        assertThat(fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}), is(6));
    }
}
