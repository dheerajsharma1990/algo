package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Num1BitsTest {

    public int numSetBits(long a) {
        int count = 0;
        long b = 1;
        while (a != 0) {
            long x = a & b;
            if (x == 1l) {
                count++;
            }
            a = a >> 1;
        }
        return count;
    }

    @Test
    public void shouldTestSetBits() {
        //then
        assertThat(numSetBits(3l), is(2));
        assertThat(numSetBits(12l), is(2));
        assertThat(numSetBits(8l), is(1));
        assertThat(numSetBits(0l), is(0));
        assertThat(numSetBits(13l), is(3));
    }

}
