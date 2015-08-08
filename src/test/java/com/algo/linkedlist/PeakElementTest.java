package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PeakElementTest {

    private int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isLarger(nums, nums[i], i - 1) && isLarger(nums, nums[i], i + 1)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isLarger(int[] nums, int current, int index) {
        return (index < 0 || index == nums.length) ? true : current > nums[index];
    }

    @Test
    public void shouldReturn0For1Element() {
        assertThat(findPeakElement(new int[]{1}), is(0));
    }

    @Test
    public void shouldReturnLastForIncreasingOrderElement() {
        assertThat(findPeakElement(new int[]{1, 2, 3}), is(2));
    }

    @Test
    public void shouldReturnFirstForDecreasingOrderElement() {
        assertThat(findPeakElement(new int[]{3, 2, 1}), is(0));
    }

    @Test
    public void shouldReturnMiddleForIncreasingDecreasingOrderElement() {
        assertThat(findPeakElement(new int[]{1, 2, 1}), is(1));
    }

}
