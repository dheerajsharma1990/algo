package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BeautifulArrangementTest {


    private int countArrangement(int N) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        map.put(2, Arrays.asList(1, 2, 4, 6, 8, 10, 12, 14));
        map.put(3, Arrays.asList(1, 3, 6, 9, 12, 15));
        map.put(4, Arrays.asList(1, 2, 4, 8, 12));
        map.put(5, Arrays.asList(1, 5, 10, 15));
        map.put(6, Arrays.asList(1, 2, 3, 6, 12));
        map.put(7, Arrays.asList(1, 7, 14));
        map.put(8, Arrays.asList(1, 2, 4, 8));
        map.put(9, Arrays.asList(1, 3, 9));
        map.put(10, Arrays.asList(1, 2, 5, 10));
        map.put(11, Arrays.asList(1, 11));
        map.put(12, Arrays.asList(1, 2, 3, 4, 6, 12));
        map.put(13, Arrays.asList(1, 13));
        map.put(14, Arrays.asList(1, 2, 7, 14));
        map.put(15, Arrays.asList(1, 3, 5, 15));
        int ans[] = new int[1];
        count(map, new HashSet<>(), N, 1, ans);
        return ans[0];
    }

    private void count(Map<Integer, List<Integer>> map, Set<Integer> set, int N, int i, int ans[]) {
        if (i > N) {
            ans[0]++;
            return;
        }
        for (int x : map.get(i)) {
            if (x <= N && !set.contains(x)) {
                set.add(x);
                count(map, set, N, i + 1, ans);
                set.remove(x);
            }
        }
    }

    @Test
    public void shouldReturnBeautifulArrangementCount() {
        assertThat(countArrangement(2), is(2));
        assertThat(countArrangement(1), is(1));
        assertThat(countArrangement(3), is(3));
        assertThat(countArrangement(8), is(132));
        assertThat(countArrangement(10), is(700));
        assertThat(countArrangement(14), is(10680));
        assertThat(countArrangement(15), is(24679));
    }
}
