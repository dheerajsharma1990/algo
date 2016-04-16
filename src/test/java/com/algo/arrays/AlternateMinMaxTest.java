package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlternateMinMaxTest {

    private void rearrange(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] >= 0) {
                int k = j;
                int temp = nums[k];
                while (temp >= 0) {
                    if (2 * (nums.length - 1 - k) < nums.length) {
                        int t = nums[2 * (nums.length - 1 - k)];
                        nums[2 * (nums.length - 1 - k)] = -1 * temp;
                        temp = t;
                        k = 2 * (nums.length - 1 - k);
                    } else {
                        int t = nums[2 * k + 1];
                        nums[2 * k + 1] = -1 * temp;
                        temp = t;
                        k = 2 * k + 1;
                    }
                }
            }
            j--;
        }

        for (int i = 0; i < len; i++) {
            nums[i] = -1 * nums[i];
        }
    }

    @Test
    public void shouldArrangeArray() {
        //given
        int[] nums1 = {1, 2};
        //when
        rearrange(nums1);

        //then
        assertThat(nums1, is(new int[]{2, 1}));

        //given
        int[] nums2 = {1, 2, 3};
        //when
        rearrange(nums2);

        //then
        assertThat(nums2, is(new int[]{3, 1, 2}));

        //given
        int[] nums3 = {1, 2, 3, 4};
        //when
        rearrange(nums3);

        //then
        assertThat(nums3, is(new int[]{4, 1, 3, 2}));
    }
}
