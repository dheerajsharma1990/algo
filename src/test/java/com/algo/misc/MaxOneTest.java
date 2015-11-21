package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class MaxOneTest {

    public List<Integer> maxone(List<Integer> a, int b) {

        int i = 0;
        int j = 0;
        int total = b;
        int max = 0;
        int maxI = i;
        while (j < a.size()) {
            if (total == 0) {
                while (j < a.size() && a.get(j) == 1) {
                    j++;
                }
                if ((j - i) > max) {
                    max = j - i;
                    maxI = i;
                }
                while (i < a.size() && a.get(i) != 0) {
                    i++;
                }
                i++;
                total++;
            }
            if (j == a.size()) {
                break;
            }
            if (a.get(j) == 0) {
                total--;
                j++;
            } else {
                j++;
            }
        }
        if ((j - i) > max) {
            max = j - i;
            maxI = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int x = maxI; x < maxI + max; x++) {
            list.add(x);
        }
        return list;
    }

    @Test
    public void shouldGetIntersectionWithDuplicates() {
        assertThat(maxone(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1), 1), hasItems(0, 1, 2, 3, 4));
        assertThat(maxone(Arrays.asList(1, 1, 1, 1), 1), hasItems(0, 1, 2, 3));
        assertThat(maxone(Arrays.asList(0, 0, 0, 0), 1), hasItems(0));
        assertThat(maxone(Arrays.asList(0, 0, 0, 0), 2), hasItems(0, 1));
        assertThat(maxone(Arrays.asList(1, 0, 0, 1), 3), hasItems(0, 1, 2, 3));
        assertThat(maxone(Arrays.asList(0, 1, 0, 1, 0, 1), 3), hasItems(0, 1, 2, 3, 4, 5));
        assertThat(maxone(Arrays.asList(0, 0, 1, 0, 0, 1, 0, 0, 1, 1), 2), hasItems(5, 6, 7, 8, 9));

        assertThat(maxone(Arrays.asList(1, 0, 1, 0, 0, 1, 0, 1, 1, 0), 0), hasItems(7, 8));
        assertThat(maxone(Arrays.asList(1, 0, 1, 0, 0, 1, 0, 1, 1, 0), 1), hasItems(5, 6, 7, 8));
        assertThat(maxone(Arrays.asList(1, 0, 1, 0, 0, 1, 0, 1, 1, 0), 2), hasItems(4, 5, 6, 7, 8));
        assertThat(maxone(Arrays.asList(1, 0, 1, 0, 0, 1, 0, 1, 1, 1), 3), hasItems(3, 4, 5, 6, 7, 8, 9));

    }
}
