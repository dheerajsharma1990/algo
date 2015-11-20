package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Search2DTest {

    public int searchMatrix(List<List<Integer>> a, int b) {
        int firstIndex = firstIndex(a, 0, a.size() - 1, b);
        return isPresent(a.get(firstIndex), 0, a.get(firstIndex).size() - 1, b);
    }

    private int firstIndex(List<List<Integer>> a, int start, int end, int b) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            return b < a.get(end).get(0) ? start : end;
        }
        int mid = start + (end - start) / 2;
        if (a.get(mid).get(0) > b) {
            return firstIndex(a, start, mid, b);
        } else {
            return firstIndex(a, mid, end, b);
        }
    }

    private int isPresent(List<Integer> list, int start, int end, int b) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (list.get(mid) == b) {
            return 1;
        } else if (list.get(mid) < b) {
            return isPresent(list, mid + 1, end, b);
        } else {
            return isPresent(list, start, mid - 1, b);
        }
    }

    @Test
    public void shouldReturn1ForPresent() {
        assertThat(searchMatrix(Arrays.asList(Arrays.asList(1, 2)), 2), is(1));
        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 3), is(1));
        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 2), is(0));

        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 0), is(0));

        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 55), is(0));

        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 10), is(1));

        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 7), is(1));

        assertThat(searchMatrix(Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)), 1), is(1));
    }

}
