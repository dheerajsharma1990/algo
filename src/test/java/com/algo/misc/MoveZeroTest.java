package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoveZeroTest {

    public void moveZeroes(int[] nums) {
        for (int j = 0, i = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    @Test
    public void shouldHaveZeroesAtEnd() {
        //given
        int[] nums = {2, 0, 1};

        //when
        moveZeroes(nums);

        //then
        assertThat(nums, is(new int[]{2, 1, 0}));
    }

    @Test
    public void shouldHaveZeroesAtEndWhenAll0() {
        //given
        int[] nums = {0, 0, 0};

        //when
        moveZeroes(nums);

        //then
        assertThat(nums, is(new int[]{0, 0, 0}));
    }

    @Test
    public void shouldHaveUnchangedArrayWhenNoZero() {
        //given
        int[] nums = {2, 1, 3};

        //when
        moveZeroes(nums);

        //then
        assertThat(nums, is(new int[]{2, 1, 3}));
    }

    @Test
    public void shouldMoveAllStartingZeroToEnd() {
        //given
        int[] nums = {0, 0, 2, 1, 3};

        //when
        moveZeroes(nums);

        //then
        assertThat(nums, is(new int[]{2, 1, 3, 0, 0}));
    }
}
