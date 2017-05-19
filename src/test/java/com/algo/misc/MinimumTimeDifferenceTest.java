package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumTimeDifferenceTest {

    private int findMinDifference(List<String> timePoints) {
        int[] allMinutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            int hour = Integer.valueOf(timePoint.substring(0, timePoint.indexOf(':')));
            int minutes = Integer.valueOf(timePoint.substring(timePoint.indexOf(':') + 1, timePoint.length()));
            allMinutes[i] = hour * 60 + minutes;
        }
        Arrays.sort(allMinutes);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < allMinutes.length; i++) {
            diff = Math.min(allMinutes[i] - allMinutes[i - 1], diff);
        }
        diff = Math.min(allMinutes[0] + 1440 - allMinutes[allMinutes.length - 1], diff);

        return diff;
    }

    @Test
    public void shouldReturnMinimumTimeDifference() {
        assertThat(findMinDifference(Arrays.asList("23:59", "00:00")), is(1));
        assertThat(findMinDifference(Arrays.asList("00:00", "03:00", "07:00")), is(180));
    }
}
