package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PowTest {

    public int pow(int x, int n, int d) {
        if (n % 2 == 1) {
            long rem = (((long) x % d) * (power(x, n - 1, d) % d)) % d;
            long val = rem < 0 ? rem + d : rem;
            return (int)val;
        }
        return  (int) power(x, n, d);
    }

    private long power(int x, int n, int d) {
        if (n == 0) {
            return x == 0 ? 0 : 1;
        } else if (n == 1) {
            return x % d;
        } else {
            int mid = n / 2;
            int result = pow(x, mid, d) % d;
            if (n % 2 == 0) {
                return (((long) (result % d) * ((long) (result % d)))) % d;
            } else {
                return ((((long) (result % d) * (long) (result % d)) % d) * (long) x) % d;
            }
        }
    }

    @Test
    public void shouldReturnCorrectResultForVariousScenarios() {
        //then
        assertThat(pow(7, 5, 5), is(2));
        assertThat(pow(2, 3, 3), is(2));
        assertThat(pow(4, 2, 2), is(0));
        assertThat(pow(0, 1, 1), is(0));
        assertThat(pow(0, 0, 1), is(0));
        assertThat(pow(24, 24, 13), is(1));
        assertThat(pow(-3, 3, 7), is(1));
        assertThat(pow(-1, 1, 20), is(19));
        assertThat(pow(-1, 2, 20), is(1));
        assertThat(pow(71045970, 41535484, 64735492), is(20805472));
    }

}
