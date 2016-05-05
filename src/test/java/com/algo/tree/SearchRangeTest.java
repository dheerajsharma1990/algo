package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchRangeTest {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int start = searchStartingPoint(a, b, 0, a.size() - 1);
        int end = searchEndingPoint(a, b, 0, a.size() - 1);
        return new ArrayList<>(Arrays.asList(start, end));
    }

    private int searchStartingPoint(List<Integer> a, int b, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return a.get(start) == b ? start : -1;
        }
        if (start + 1 == end) {
            return a.get(start) == b ? start : a.get(end) == b ? end : -1;
        }
        int mid = start + (end - start) / 2;
        if (a.get(mid) == b) {
            return searchStartingPoint(a, b, start, mid);
        } else if (a.get(mid) < b) {
            return searchStartingPoint(a, b, mid + 1, end);
        } else {
            return searchStartingPoint(a, b, start, mid - 1);
        }
    }

    private int searchEndingPoint(List<Integer> a, int b, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return a.get(start) == b ? start : -1;
        }
        if (start + 1 == end) {
            return a.get(end) == b ? end : a.get(start) == b ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (a.get(mid) == b) {
            return searchEndingPoint(a, b, mid, end);
        } else if (a.get(mid) < b) {
            return searchEndingPoint(a, b, mid + 1, end);
        } else {
            return searchEndingPoint(a, b, start, mid - 1);
        }
    }

    @Test
    public void shouldSearchStartingEndingPoint() {
        assertThat(searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 8), is(Arrays.asList(3, 4)));
        assertThat(searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 5), is(Arrays.asList(0, 0)));
        assertThat(searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 9), is(Arrays.asList(-1, -1)));
        assertThat(searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 10), is(Arrays.asList(5, 5)));
        assertThat(searchRange(new ArrayList<Integer>(), 10), is(Arrays.asList(-1, -1)));
        assertThat(searchRange(Arrays.asList(1), 1), is(Arrays.asList(0, 0)));
        assertThat(searchRange(Arrays.asList(1, 1, 1), 1), is(Arrays.asList(0, 2)));
    }
}
