package com.algo.dp;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumSquaresSum {
    public int numSquares(int n) {
        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            max[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            int square = i * i;
            for (int j = 1; j <= n; j++) {
                if (square <= j) {
                    int count = j / square;
                    int rem = j % square;
                    max[j] = Math.min(max[j], count + max[rem]);
                }
            }
        }
        return max[n];
    }

    @Test
    public void shouldReturnMinimumSquareSumNumber() {
        assertThat(numSquares(6), is(3));
        assertThat(numSquares(12), is(3));
        assertThat(numSquares(13), is(2));
        assertThat(numSquares(1), is(1));
        assertThat(numSquares(2), is(2));
        assertThat(numSquares(50), is(2));
        assertThat(numSquares(25), is(1));
        assertThat(numSquares(61), is(2));
    }
}
