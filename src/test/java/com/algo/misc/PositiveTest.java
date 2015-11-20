package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PositiveTest {

    public int firstMissingPositive(List<Integer> a) {
        int i = 0;
        int j = 0;
        int max = a.size();
        while (j < a.size()) {
            if (a.get(j) >= 1 && a.get(j) <= max) {
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
                i++;
            }
            j++;
        }

        for (int x = 0; x < i; x++) {
            int val = Math.abs(a.get(x));
            if (a.get(val - 1) > 0) {
                a.set(val - 1, -1 * a.get(val - 1));
            }
        }
        int p = 0;
        while (p < i && a.get(p) < 0) {
            p++;
        }
        return p + 1;
    }

    @Test
    public void shouldTestVariousScenarios() {
        //then
        assertThat(firstMissingPositive(Arrays.asList(1, 2, 0)), is(3));
        assertThat(firstMissingPositive(Arrays.asList(3,4,-1,1)), is(2));
        assertThat(firstMissingPositive(Arrays.asList(-8, -7, -6)), is(1));
        assertThat(firstMissingPositive(Arrays.asList(1, 1, 1)), is(2));
        assertThat(firstMissingPositive(Arrays.asList(0, 0, 0)), is(1));
        assertThat(firstMissingPositive(Arrays.asList(1, 2, 3)), is(4));
        assertThat(firstMissingPositive(Arrays.asList(3, 3, 2)), is(1));
    }

}
