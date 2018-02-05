package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindDuplicatesTest {

    private List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] > 2 * nums.length)
                .map(i -> i + 1)
                .boxed()
                .collect(Collectors.toList());
    }


    @Test
    public void shouldFindDuplicates() {
        //given
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};

        //then
        assertThat(findDuplicates(nums1), is(equalTo(Arrays.asList(2, 3))));

        //given
        int[] nums2 = {1, 1};

        //then
        assertThat(findDuplicates(nums2), is(equalTo(Arrays.asList(1))));

        //given
        int[] nums3 = {2, 1, 2, 1};

        //then
        assertThat(findDuplicates(nums3), is(equalTo(Arrays.asList(1, 2))));

        //given
        int[] nums4 = {2, 2};

        //then
        assertThat(findDuplicates(nums4), is(equalTo(Arrays.asList(2))));
    }
}
