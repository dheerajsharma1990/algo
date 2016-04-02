package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RectangleTotalAreaTest {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int firstLength = Math.abs(D - B);
        int firstBreadth = Math.abs(C - A);
        int firstArea = firstBreadth * firstLength;
        int secondLength = Math.abs(H - F);
        int secondBreadth = Math.abs(G - E);
        int secondArea = secondLength * secondBreadth;

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);

        int commonArea = 0;
        if (left < right && bottom < top) {
            commonArea = Math.abs(right - left) * Math.abs(top - bottom);
        }
        return firstArea + secondArea - commonArea;

    }

    @Test
    public void shouldGetTotalArea() {
        assertThat(computeArea(-3, 0, 3, 4, 0, -1, 9, 2), is(45));
        assertThat(computeArea(-3, 0, 3, 4, 1, 1, 7, 8), is(60));
        assertThat(computeArea(-3, 0, 3, 4, -4, -5, -2, 1), is(35));
    }
}
