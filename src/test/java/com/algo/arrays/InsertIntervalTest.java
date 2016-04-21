package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InsertIntervalTest {

    class Interval {
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
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        if(intervals.isEmpty()) {
            ans.add(newInterval);
            return ans;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                ans.add(interval);
                continue;
            } else {
                int start = Math.min(interval.start, newInterval.start);
                while (i < intervals.size() && intervals.get(i).end < newInterval.end) {
                    i++;
                }
                if (i == intervals.size()) {
                    ans.add(new Interval(start, newInterval.end));
                } else {
                    if (intervals.get(i).start > newInterval.end) {
                        ans.add(new Interval(start, newInterval.end));
                        while (i < intervals.size()) {
                            ans.add(intervals.get(i));
                            i++;
                        }
                    } else {
                        ans.add(new Interval(start, intervals.get(i).end));
                        i++;
                        while (i < intervals.size()) {
                            ans.add(intervals.get(i));
                            i++;
                        }
                    }
                }
            }
        }
        Interval lastInterval = ans.get(ans.size() - 1);
        if (lastInterval.end < newInterval.start) {
            ans.add(newInterval);
        }
        return ans;
    }

    @Test
    public void shouldTestInsertInterval() {
        assertThat(insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5)).size(), is(2));
        assertThat(insert(Arrays.asList(new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)), new Interval(4, 9)).size(), is(3));
        assertThat(insert(Arrays.asList(new Interval(1, 2)), new Interval(4, 9)).size(), is(2));
        assertThat(insert(Arrays.asList(new Interval(1, 2)), new Interval(0, 1)).size(), is(1));
        assertThat(insert(Arrays.asList(new Interval(1, 2)), new Interval(-1, 0)).size(), is(2));
        assertThat(insert(Arrays.asList(new Interval(1, 2), new Interval(3, 4)), new Interval(-1, 0)).size(), is(3));
        assertThat(insert(Arrays.asList(new Interval(1, 2), new Interval(3, 4)), new Interval(4, 5)).size(), is(2));
        assertThat(insert(Arrays.asList(new Interval(1, 2), new Interval(3, 4)), new Interval(2, 3)).size(), is(1));
        assertThat(insert(Arrays.asList(new Interval(1, 2), new Interval(3, 4)), new Interval(0, 5)).size(), is(1));
        assertThat(insert(Arrays.asList(new Interval(1, 6), new Interval(9, 10)), new Interval(7, 8)).size(), is(3));
        assertThat(insert(Arrays.asList(new Interval(1, 6), new Interval(9, 10),new Interval(11, 12)), new Interval(9, 12)).size(), is(2));
    }
}
