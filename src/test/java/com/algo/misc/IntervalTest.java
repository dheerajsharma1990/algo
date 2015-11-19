package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntervalTest {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (end != interval.end) return false;
            if (start != interval.start) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval.end < newInterval.start) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }
        ArrayList<Interval> list = new ArrayList<>();
        int i = 0;
        boolean changed = false;
        while (i < intervals.size()) {
            if (newInterval.start < intervals.get(i).start) {
                while (i < intervals.size() && intervals.get(i).end < newInterval.end) {
                    i++;
                }
                if (i == intervals.size() || newInterval.end < intervals.get(i).start) {
                    list.add(newInterval);
                } else {
                    list.add(new Interval(newInterval.start, intervals.get(i).end));
                    i++;
                }
                changed = true;
                break;
            } else if (intervals.get(i).end < newInterval.start) {
                list.add(intervals.get(i));
                i++;
            } else {
                int startPoint = intervals.get(i).start;
                while (i < intervals.size() && intervals.get(i).end < newInterval.end) {
                    i++;
                }
                if (i == intervals.size() || newInterval.end < intervals.get(i).start) {
                    list.add(new Interval(startPoint, newInterval.end));
                } else {
                    list.add(new Interval(startPoint, intervals.get(i).end));
                    i++;
                }
                changed = true;
                break;
            }
        }

        while (i < intervals.size()) {
            list.add(intervals.get(i++));
        }
        if (!changed) {
            list.add(newInterval);
        }
        return list;
    }

    @Test
    public void shouldReturnCorrectResultForSingleNode() {
        //then
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(0, 1)), hasItems(new Interval(0, 1), new Interval(2, 4)));
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(0, 1)).size(), is(2));
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(0, 3)), hasItems(new Interval(0, 4)));
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(0, 3)).size(), is(1));
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(4, 5)), hasItems(new Interval(2, 5)));
        assertThat(insert(Arrays.asList(new Interval(2, 4)), new Interval(4, 5)).size(), is(1));
    }

    @Test
    public void shouldReturnCorrectResultForMultipleNodes() {
        //then
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(0, 1)), hasItems(new Interval(0, 1), new Interval(2, 4), new Interval(6, 7)));
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(0, 1)).size(), is(3));

        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(0, 2)), hasItems(new Interval(0, 4), new Interval(6, 7)));
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(0, 2)).size(), is(2));

        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(3, 5)), hasItems(new Interval(2, 5), new Interval(6, 7)));
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 7)), new Interval(3, 5)).size(), is(2));

        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 8)), new Interval(3, 7)), hasItems(new Interval(2, 8)));
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 8)), new Interval(3, 7)).size(), is(1));

        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 8)), new Interval(10, 9)).size(), is(3));
        assertThat(insert(Arrays.asList(new Interval(2, 4), new Interval(6, 8)), new Interval(10, 9)), hasItems(new Interval(2, 4), new Interval(6, 8), new Interval(9, 10)));

    }
}
