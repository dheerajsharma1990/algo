package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MergeIntervalsTest {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (start != interval.start) return false;
            return end == interval.end;

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    private List<Interval> getSortedIntervals(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start == interval2.start ? interval1.end - interval2.end : interval1.start - interval2.start;
            }
        });

        List<Interval> ans = new ArrayList<>();

        if (!intervals.isEmpty()) {
            int i = 0;
            while (i < intervals.size()) {
                Interval currentInterval = intervals.get(i);
                int start = currentInterval.start;
                int end = currentInterval.end;
                i++;
                while (i < intervals.size() && intervals.get(i).start <= end) {
                    if (intervals.get(i).end > end) {
                        end = intervals.get(i).end;
                    }
                    i++;
                }
                ans.add(new Interval(start, end));
            }
        }

        return ans;
    }

    @Test
    public void shouldGetCorrectResultForVariousScenarios() {
        //then
        List<Interval> intervals = getSortedIntervals(Arrays.asList(new Interval(2, 3)));
        assertThat(intervals.size(), is(1));
        assertThat(intervals.get(0), is(new Interval(2, 3)));

        intervals = getSortedIntervals(Arrays.asList(new Interval(3, 7), new Interval(2, 5)));
        assertThat(intervals.size(), is(1));
        assertThat(intervals.get(0), is(new Interval(2, 7)));

        intervals = getSortedIntervals(Arrays.asList(new Interval(3, 4), new Interval(3, 6)));
        assertThat(intervals.size(), is(1));
        assertThat(intervals.get(0), is(new Interval(3, 6)));

        intervals = getSortedIntervals(Arrays.asList(new Interval(3, 4), new Interval(4, 5)));
        assertThat(intervals.size(), is(1));
        assertThat(intervals.get(0), is(new Interval(3, 5)));

        intervals = getSortedIntervals(Arrays.asList(new Interval(4, 5), new Interval(1, 2)));
        assertThat(intervals.size(), is(2));
        assertThat(intervals.get(0), is(new Interval(1, 2)));
        assertThat(intervals.get(1), is(new Interval(4, 5)));
    }

}
