package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class IntersectTest {

    public List<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                i++;
            } else if (a.get(i) > b.get(j)) {
                j++;
            } else {
                list.add(a.get(i));
                i++;
                j++;
            }
        }
        return list;
    }

    @Test
    public void shouldGetIntersectionWithDuplicates() {
        assertThat(intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(3, 3, 5)), hasItems(3, 3, 5));
        assertThat(intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(3, 5)), hasItems(3, 5));
        assertThat(intersect(Arrays.asList(1, 1, 1), Arrays.asList(2, 2)).size(), is(0));
        assertThat(intersect(Arrays.asList(1, 1, 2, 2, 3, 3, 3), Arrays.asList(2, 2, 2)), hasItems(2, 2));
        assertThat(intersect(Arrays.asList(1), Arrays.asList(1)), hasItems(1, 1));
    }
}
