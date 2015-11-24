package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongestConsecutiveTest {

    public int longestConsecutive(final List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, 0);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                belowVal(map, entry.getKey());
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer v : map.values()) {
            max = max > v ? max : v;
        }
        return max;
    }

    private int belowVal(Map<Integer, Integer> map, int val) {
        if (!map.containsKey(val)) {
            return 0;
        } else if (map.get(val) != 0) {
            return map.get(val);
        } else {
            if (val == Integer.MIN_VALUE) {
                map.put(val, 1);
                return 1;
            } else {
                int x = 1 + belowVal(map, val - 1);
                map.put(val, x);
                return x;
            }
        }
    }

    @Test
    public void shouldGetMaxLength() {
        assertThat(longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2)), is(4));
        assertThat(longestConsecutive(Arrays.asList(1)), is(1));
        assertThat(longestConsecutive(Arrays.asList(1, 2, 3)), is(3));
        assertThat(longestConsecutive(Arrays.asList(-1, 2, -3)), is(1));
        assertThat(longestConsecutive(Arrays.asList(-1, 2, -3)), is(1));
        assertThat(longestConsecutive(Arrays.asList(3, 2, 1)), is(3));
        assertThat(longestConsecutive(Arrays.asList(3, 2, 1, 4, 5, 6)), is(6));
        assertThat(longestConsecutive(Arrays.asList(2, 2, 1, 1, 3, 3)), is(3));
        assertThat(longestConsecutive(Arrays.asList(2, 2, 1, 1, 3, 3, 4)), is(4));
    }
}
