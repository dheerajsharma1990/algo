package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DistinctCandiesTest {


    private int distributeCandies(int[] candies) {
        long distinct = Arrays.stream(candies).distinct().count();
        return 2 * distinct <= candies.length ? (int) distinct : Math.min((int) distinct, candies.length / 2);
    }


    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}), is(3));
        assertThat(distributeCandies(new int[]{1, 1, 2, 3}), is(2));
        assertThat(distributeCandies(new int[]{1000, 1, 1, 1}), is(2));

    }
}
