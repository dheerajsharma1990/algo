package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DuplicateNumTest {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        xor = xor & ~(xor - 1);
        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((xor & num) != 0) {
                first = first ^ num;
            } else {
                second = second ^ num;
            }
        }
        return new int[]{first, second};
    }

    @Test
    public void shouldGetDuplicateElements() {
        assertThat(singleNumber(new int[]{1, 2, 1, 3, 2, 4, 5, 4}), is(new int[]{3, 5}));
        assertThat(singleNumber(new int[]{1, 1, 2, 3}), is(new int[]{3, 2}));
        assertThat(singleNumber(new int[]{2, 2, 0, 1}), is(new int[]{1, 0}));
    }
}
