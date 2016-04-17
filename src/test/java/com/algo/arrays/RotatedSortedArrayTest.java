package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RotatedSortedArrayTest {

    public int search(int[] nums, int target) {
        int i = findMinIndex(nums, 0, nums.length - 1);
        int idx1 = findNum(nums, 0, i - 1, target);
        int idx2 = findNum(nums, i, nums.length - 1, target);
        return idx1 == -1 ? idx2 : idx1;
    }

    private int findNum(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return findNum(nums, start, mid - 1, target);
        } else {
            return findNum(nums, mid + 1, end, target);
        }
    }

    private int findMinIndex(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            return nums[start + 1] < nums[end] ? start + 1 : end;
        }
        if (start + 2 == end) {
            int min1 = nums[start] < nums[start + 1] ? start : start + 1;
            return nums[min1] < nums[end] ? min1 : end;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
            return mid;
        } else {
            if (nums[start] < nums[end]) {
                return findMinIndex(nums, start, mid);
            } else {
                if (nums[mid] > nums[start]) {
                    return findMinIndex(nums, mid, end);
                } else {
                    return findMinIndex(nums, start, mid);
                }
            }
        }
    }

    @Test
    public void shouldFindNumberInRotatedArray() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 0), is(4));
        assertThat(search(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 0), is(5));
        assertThat(search(new int[]{2, 3, 4, 5, 6, 7, 0, 1}, 0), is(6));
        assertThat(search(new int[]{1, 2, 3, 4, 5, 6, 7, 0}, 0), is(7));
        assertThat(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 0), is(0));
        assertThat(search(new int[]{7, 0, 1, 2, 3, 4, 5, 6}, 0), is(1));
        assertThat(search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 0), is(2));
        assertThat(search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 0), is(3));
        assertThat(search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 8), is(-1));
    }
}
