package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Sum3Test {

    public int threeSumClosest(List<Integer> a, int b) {
        Collections.sort(a);
        int totalSum = b;
        boolean found = false;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < a.size() - 2 && !found; i++) {
            int sum = b - a.get(i);
            int j = 0, k = a.size() - 1;
            while (j < k) {
                if (i == j) {
                    j++;
                    continue;
                } else if (i == k) {
                    k--;
                    continue;
                } else {
                    int twoSum = a.get(j) + a.get(k);
                    if (Math.abs(twoSum - sum) < diff) {
                        totalSum = twoSum + a.get(i);
                        diff = Math.abs(twoSum - sum);
                    }
                    if (twoSum < sum) {
                        j++;
                    } else if (twoSum > sum) {
                        k--;
                    } else {
                        found = true;
                        break;
                    }
                }
            }
        }
        return totalSum;
    }

    @Test
    public void shouldTestSetBits() {
        //then
        assertThat(threeSumClosest(Arrays.asList(-1, 2, 1, -4), 1), is(2));
        assertThat(threeSumClosest(Arrays.asList(-1, 2, 1, -4), 2), is(2));
        assertThat(threeSumClosest(Arrays.asList(-1, 2, 1, -4), 5), is(2));
        assertThat(threeSumClosest(Arrays.asList(1, 2, 1, -4), 5), is(4));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1, 2), 5), is(3));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1, 2), -4), is(0));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1), 2), is(0));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1), 5), is(0));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1), -3), is(0));
        assertThat(threeSumClosest(Arrays.asList(-1, 0, 1), 0), is(0));
        assertThat(threeSumClosest(Arrays.asList(-4, -3, -2, -1), 0), is(-6));
        assertThat(threeSumClosest(Arrays.asList(0, 2, 1, -3), 1), is(0));
    }
}
