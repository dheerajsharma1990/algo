package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SqrtTest {

    public int sqrt(int a) {
        int previous = 0;
        int current = 1;
        long result = 1l;
        while (result < a) {
            previous = current;
            current = current * 2;
            result = (long) current * (long) current;
        }
        for (int i = previous; i < current; i++) {
            result = (long) i * (long) i;
            long result1 = (long) (i + 1) * (long) (i + 1);
            if (result == a || (a > result && a < result1)) {
                return i;
            }
        }
        return current;
    }

    private int sqrt(int start, int end, int num) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            return end * end == num ? end : start;
        }
        int mid = start + (end - start) / 2;
        long mul = mid * mid;
        if (mul == num) {
            return mid;
        } else if (mul < num) {
            return sqrt(mid, end, num);
        } else {
            return sqrt(start, mid, num);
        }
    }

    @Test
    public void shouldTestForVariousSqrts() {
        //then
        assertThat(sqrt(0), is(0));
        assertThat(sqrt(1), is(1));
        assertThat(sqrt(2), is(1));
        assertThat(sqrt(3), is(1));
        assertThat(sqrt(4), is(2));
        assertThat(sqrt(5), is(2));
        assertThat(sqrt(6), is(2));
        assertThat(sqrt(7), is(2));
        assertThat(sqrt(8), is(2));
        assertThat(sqrt(9), is(3));

        assertThat(sqrt(10), is(3));
        assertThat(sqrt(11), is(3));
        assertThat(sqrt(12), is(3));
        assertThat(sqrt(13), is(3));
        assertThat(sqrt(14), is(3));
        assertThat(sqrt(15), is(3));
        assertThat(sqrt(16), is(4));
        assertThat(sqrt(17), is(4));
        assertThat(sqrt(18), is(4));
        assertThat(sqrt(19), is(4));

        assertThat(sqrt(930675566), is(30506));
        assertThat(sqrt(530751374), is(23038));
        assertThat(sqrt(2147483647), is(46340));
    }
}
