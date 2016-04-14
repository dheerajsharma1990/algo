package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JumpGame2Test {

    public int jump(int[] nums) {
        int[] aux = new int[nums.length];
        int i = 0, j = 0;
        aux[0] = 0;
        while (j < (nums.length - 1)) {
            int max = i + nums[i];
            if (max > j) {
                int k = j + 1;
                while (k < nums.length && k <= max) {
                    aux[k] = aux[i] + 1;
                    k++;
                }
                j = max;
            }
            i++;
        }
        return aux[nums.length - 1];
    }

    @Test
    public void shouldReturnMinimumJumps() {
        assertThat(jump(new int[]{1}), is(0));
        assertThat(jump(new int[]{2, 3, 1, 1, 4}), is(2));
        assertThat(jump(new int[]{1, 1, 1, 1}), is(3));
        assertThat(jump(new int[]{4, 3, 2, 1}), is(1));
        assertThat(jump(new int[]{4, 3}), is(1));
        assertThat(jump(new int[]{1, 2}), is(1));
        assertThat(jump(new int[]{3, 1, 0, 2, 0, 1}), is(2));
        assertThat(jump(new int[]{3, 1, 0, 2, 0, 0}), is(2));
        assertThat(jump(new int[]{2, 0, 2, 0, 2, 0, 0}), is(3));
    }
}
