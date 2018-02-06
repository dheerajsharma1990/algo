package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayNestingTest {

    private int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(visited.contains(i)) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int j = i;
            while (!set.contains(nums[j])) {
                visited.add(j);
                set.add(nums[j]);
                j = nums[j];
            }
            max = Math.max(max, set.size());
        }
        return max;
    }


    @Test
    public void shouldNestArray() {
        assertThat(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}), is(4));
        assertThat(arrayNesting(new int[]{1, 2, 3, 0}), is(4));
        assertThat(arrayNesting(new int[]{1, 3, 2, 0}), is(3));
        assertThat(arrayNesting(new int[]{0}), is(1));
    }
}
