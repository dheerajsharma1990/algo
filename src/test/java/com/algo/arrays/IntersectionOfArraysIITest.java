package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IntersectionOfArraysIITest {

    private int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> firstCount = Arrays.stream(nums1)
                .mapToObj(Integer::new)
                .collect(groupingBy(identity(), summingInt(i -> 1)));
        Map<Integer, Integer> secondCount = Arrays.stream(nums2)
                .mapToObj(Integer::new)
                .collect(groupingBy(identity(), summingInt(i -> 1)));

        return firstCount.entrySet()
                .stream()
                .filter(entry -> secondCount.containsKey(entry.getKey()))
                .map(entry -> IntStream.generate(entry::getKey)
                        .limit(Math.min(entry.getValue(), secondCount.get(entry.getKey())))
                        .toArray())
                .flatMapToInt(IntStream::of)
                .toArray();


    }

    @Test
    public void shouldFindIntersectionOfTwoArrays() {
        assertThat(intersect(new int[]{1, 2}, new int[]{2, 1}).length, is(2));
        assertThat(intersect(new int[]{2, 4, 2, 4}, new int[]{2, 2}).length, is(2));
        assertThat(intersect(new int[]{2, 4, 2, 4}, new int[]{2, 2})[0], is(2));
        assertThat(intersect(new int[]{2, 4, 2, 4}, new int[]{2, 2})[1], is(2));
        assertThat(intersect(new int[]{1, 2, 2, 2, 3}, new int[]{1, 2, 2}).length, is(3));
        assertThat(intersect(new int[]{1, 2, 2, 2, 3}, new int[]{1, 2}).length, is(2));
    }

}
