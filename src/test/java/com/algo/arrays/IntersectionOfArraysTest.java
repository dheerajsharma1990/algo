package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IntersectionOfArraysTest {

    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2)
                .mapToObj(Integer::new)
                .collect(Collectors.toSet());
        return Arrays.stream(nums1)
                .filter(set::contains)
                .distinct()
                .toArray();
    }

    @Test
    public void shouldFindIntersectionOfTwoArrays() {
        assertThat(intersection(new int[]{2, 4, 2, 4}, new int[]{2, 2}).length, is(1));
        assertThat(intersection(new int[]{2, 4, 2, 4}, new int[]{2, 2})[0], is(2));
        assertThat(intersection(new int[]{1, 2, 3}, new int[]{4, 5, 6}).length, is(0));
        assertThat(intersection(new int[]{1}, new int[]{1}).length, is(1));
        assertThat(intersection(new int[]{1}, new int[]{1})[0], is(1));
    }

}
