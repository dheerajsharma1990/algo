package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstPositiveMissingTest {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                nums[j] = -1;
            }
            if (nums[j] > 0) {
                j++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        int positiveStart = i;
        for (j = i; j < nums.length; j++) {
            int val = Math.abs(nums[j]);
            val = val - 1;
            if (val < nums.length) {
                if ((val < positiveStart && nums[val] < 0) || (val >= positiveStart && nums[val] > 0)) {
                    nums[val] = -1 * nums[val];
                }
            }
        }
        for (j = 0; j < positiveStart; j++) {
            if (nums[j] < 0) {
                return j + 1;
            }
        }
        for (j = i; j < nums.length; j++) {
            if (nums[j] > 0) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    @Test
    public void shouldGetFirstMissingNumber() {
        assertThat(firstMissingPositive(new int[]{2}), is(1));
        assertThat(firstMissingPositive(new int[]{3, 4, -1, 1}), is(2));
        assertThat(firstMissingPositive(new int[]{1, 2, 0}), is(3));
        assertThat(firstMissingPositive(new int[]{0}), is(1));
        assertThat(firstMissingPositive(new int[]{0, 0}), is(1));
        assertThat(firstMissingPositive(new int[]{4, 5}), is(1));
        assertThat(firstMissingPositive(new int[]{-1, -2}), is(1));
        assertThat(firstMissingPositive(new int[]{1, -2}), is(2));
        assertThat(firstMissingPositive(new int[]{1, -2}), is(2));
        assertThat(firstMissingPositive(new int[]{1, 2}), is(3));
        assertThat(firstMissingPositive(new int[]{1, 1}), is(2));
        assertThat(firstMissingPositive(new int[]{-1, 1, 1, 3, 3}), is(2));
    }
}
