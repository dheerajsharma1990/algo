package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CanJumpTest {
    public int canJump(List<Integer> a) {
        int i = 0;
        int j = a.get(i);
        for (;
             i <= j && j < a.size() - 1;
             i++) {
            if (a.get(i) + i > j) {
                j = a.get(i) + i;
            }
        }
        return j < (a.size() - 1) ? 0 : 1;
    }

    @Test
    public void shouldTestMaxAdjacent() {
        assertThat(canJump(Arrays.asList(2, 3, 1, 1, 4)), is(1));
        assertThat(canJump(Arrays.asList(3, 2, 1, 0, 4)), is(0));
        assertThat(canJump(Arrays.asList(1, 1)), is(1));
        assertThat(canJump(Arrays.asList(0)), is(1));
        assertThat(canJump(Arrays.asList(0, 1)), is(0));
    }
}
