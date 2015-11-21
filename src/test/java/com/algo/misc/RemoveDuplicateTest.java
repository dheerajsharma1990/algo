package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveDuplicateTest {

    public int removeDuplicates(List<Integer> a) {
        int i = 0;
        int j = 1;
        while (j < a.size()) {
            if (!a.get(i).equals(a.get(j))) {
                a.set(++i, a.get(j));
            }
            j++;
        }
        return i + 1;

    }

    @Test
    public void shouldGetIntersectionWithDuplicates() {
        assertThat(removeDuplicates(Arrays.asList(1, 1, 2)), is(2));
        assertThat(removeDuplicates(Arrays.asList(1, 2, 3)), is(3));
        assertThat(removeDuplicates(Arrays.asList(1, 1, 1)), is(1));
        assertThat(removeDuplicates(Arrays.asList(5000, 5000, 5000)), is(1));
    }
}
