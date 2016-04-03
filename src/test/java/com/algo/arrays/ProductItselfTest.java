package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProductItselfTest {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int mul = 1;
        int zeroCount = 0;
        for (int n : nums) {
            if (n == 0) {
                if (zeroCount < 1) {
                    zeroCount++;
                    continue;
                } else {
                    mul = 0;
                    break;
                }
            }
            mul = mul * n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                output[i] = nums[i] == 0 ? mul : 0;
            } else {
                output[i] = nums[i] == 0 ? mul : mul / nums[i];
            }
        }
        return output;
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(productExceptSelf(new int[]{2, 7, 3, 0, 5}), is(new int[]{0, 0, 0, 210, 0}));
        assertThat(productExceptSelf(new int[]{0, 7, 3, 0, 5}), is(new int[]{0, 0, 0, 0, 0}));
        assertThat(productExceptSelf(new int[]{0, 7, 3, 1, 5}), is(new int[]{105, 0, 0, 0, 0}));
        assertThat(productExceptSelf(new int[]{1, 2, 3, 4, 5}), is(new int[]{120, 60, 40, 30, 24}));
    }
}
