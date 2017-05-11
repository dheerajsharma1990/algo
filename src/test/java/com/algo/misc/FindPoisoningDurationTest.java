package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindPoisoningDurationTest {


    private int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = -1;
        int total = 0;
        for (int t : timeSeries) {
            if (t > time) {
                time = t + duration - 1;
                total += duration;
            } else {
                int max = t + duration - 1;
                if (max > time) {
                    total += (max - time);
                    time = max;
                }
            }
        }
        return total;
    }

    @Test
    public void shouldReturnCorrectDuration() {
        assertThat(findPoisonedDuration(new int[]{1, 4}, 2), is(4));
        assertThat(findPoisonedDuration(new int[]{1, 2}, 2), is(3));
        assertThat(findPoisonedDuration(new int[]{1, 2, 3}, 5), is(7));
        assertThat(findPoisonedDuration(new int[]{1, 4, 6}, 10), is(15));
        assertThat(findPoisonedDuration(new int[]{1, 4, 6}, 1), is(3));
        assertThat(findPoisonedDuration(new int[]{1, 4, 6}, 3), is(8));
        assertThat(findPoisonedDuration(new int[]{0, 1, 2}, 1), is(3));
    }
}
