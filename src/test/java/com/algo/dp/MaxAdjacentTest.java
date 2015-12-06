package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxAdjacentTest {
    public int adjacent(List<List<Integer>> a) {
        int max[] = new int[a.get(0).size()];
        for (int i = 0; i < a.get(0).size(); i++) {
            max[i] = Math.max(Math.max(a.get(0).get(i), a.get(1).get(i)) + ((i - 2) >= 0 ? max[i - 2] : 0),
                    (i - 1 >= 0 ? max[i - 1] : 0));
        }
        return max[a.get(0).size() - 1];
    }

    @Test
    public void shouldTestMaxAdjacent() {
        assertThat(adjacent(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 4, 5))), is(8));
        assertThat(adjacent(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(-1, -2, -3))), is(4));
        assertThat(adjacent(Arrays.asList(Arrays.asList(14, 87, 36, 23), Arrays.asList(37, 59, 21, 68))), is(155));
        assertThat(adjacent(Arrays.asList(Arrays.asList(16, 5, 54, 55, 36, 82, 61, 77, 66, 61),
                Arrays.asList(31, 30, 36, 70, 9, 37, 1, 11, 68, 14))), is(321));
    }
}
