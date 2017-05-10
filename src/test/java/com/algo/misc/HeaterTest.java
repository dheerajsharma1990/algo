package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HeaterTest {

    private int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int closestHeater = 0;
        int radius = Integer.MIN_VALUE;
        for (int house : houses) {
            int distance = Math.abs(house - heaters[closestHeater]);
            while (closestHeater + 1 < heaters.length && Math.abs(house - heaters[closestHeater + 1]) <= distance) {
                distance = Math.abs(house - heaters[closestHeater + 1]);
                closestHeater++;
            }
            radius = Math.max(radius, distance);
        }
        return radius;
    }


    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(findRadius(new int[]{1, 2, 3}, new int[]{2}), is(1));
        assertThat(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}), is(1));
        assertThat(findRadius(new int[]{1, 2, 3, 4}, new int[]{2}), is(2));
        assertThat(findRadius(new int[]{4}, new int[]{1, 2}), is(2));
        assertThat(findRadius(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}), is(0));
    }

}
