package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RotateArrayTest {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        for (int i = start; i <= (start + ((end - start) / 2)) && end >= start; i++) {
            int temp = arr[i];
            arr[i] = arr[end - i + start];
            arr[end - i + start] = temp;
        }
    }

    @Test
    public void shouldRotate() {
        //given
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        assertThat(arr, is(new int[]{5, 6, 7, 1, 2, 3, 4}));
    }
}
