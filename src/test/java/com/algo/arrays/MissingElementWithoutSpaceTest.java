package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MissingElementWithoutSpaceTest {

    private List<Integer> findDisappearedNumbers(int[] nums) {
        IntStream.range(0, nums.length).forEach(i -> {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = nums[num] < 0 ? nums[num] : -1 * nums[num];
        });
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] > 0)
                .map(i -> i + 1).boxed().collect(Collectors.toList());
    }

    @Test
    public void shouldFindMissingNumbers() {
        assertThat(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).size(), is(2));
        assertThat(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).contains(5), is(true));
        assertThat(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).contains(6), is(true));

        assertThat(findDisappearedNumbers(new int[]{2, 2}).contains(1), is(true));
        assertThat(findDisappearedNumbers(new int[]{2, 2}).size(), is(1));

    }
}
