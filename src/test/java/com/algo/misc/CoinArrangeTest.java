package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinArrangeTest {


    private int arrangeCoins(int n) {
        int root = (int) Math.sqrt( (long) 2 * n);
        while ( ( ((long) root * (root + 1))) / 2  > n ) {
            root--;
        }
        return root;

    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(arrangeCoins(1), is(1));
        assertThat(arrangeCoins(2), is(1));
        assertThat(arrangeCoins(3), is(2));
        assertThat(arrangeCoins(1804292553), is(60070));

    }
}
