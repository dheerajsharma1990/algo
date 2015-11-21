package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SingleTest {

    public int singleNumber(final List<Integer> a) {
        int num = 0;
        for (int x : a) {
            num = num ^ x;
        }
        return num;
    }

    @Test
    public void shouldTestSetBits() {
        //then
        assertThat(singleNumber(Arrays.asList(1, 2, 2, 3, 1)), is(3));
        assertThat(singleNumber(Arrays.asList(10, 10, 11, 12, 12)), is(11));
        assertThat(singleNumber(Arrays.asList(0, 0, 0, 11, 0)), is(11));

    }
}
