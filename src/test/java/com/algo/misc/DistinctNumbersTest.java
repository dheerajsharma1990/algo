package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class DistinctNumbersTest {

    public List<Integer> dNums(List<Integer> A, int B) {
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        while (j < B && j < A.size()) {
            if (!map.containsKey(A.get(j))) {
                map.put(A.get(j), 1);
                count++;
            } else {
                map.put(A.get(j), map.get(A.get(j)) + 1);
            }
            j++;
        }

        ans.add(count);

        while (j < A.size()) {
            int num = A.get(i);
            if (map.get(num) == 1) {
                count--;
            }
            i++;
            map.put(num, map.get(num) - 1);
            if (!map.containsKey(A.get(j)) || map.get(A.get(j)) == 0) {
                count++;
                if (!map.containsKey(A.get(j))) {
                    map.put(A.get(j), 1);
                } else {
                    map.put(A.get(j), map.get(A.get(j)) + 1);
                }
            } else {
                map.put(A.get(j), map.get(A.get(j)) + 1);
            }
            ans.add(count);
            j++;
        }
        return ans;
    }

    @Test
    public void shouldGetCorrectDistinctNumbersCount() {
        assertThat(dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3), hasItems(2, 3, 3, 2));
        assertThat(dNums(Arrays.asList(1, 1, 1, 1, 1), 3), hasItems(1, 1, 1));
        assertThat(dNums(Arrays.asList(1, 1, 1, 1, 1), 1), hasItems(1, 1, 1, 1, 1, 1));
        assertThat(dNums(Arrays.asList(1, 1, 1, 1, 1), 7), hasItems(1));
        assertThat(dNums(Arrays.asList(1, 1, 1, 1, 1), 6), hasItems(1));
        assertThat(dNums(Arrays.asList(1, 2, 3, 4, 5), 2), hasItems(2, 2, 2, 2));
    }
}
