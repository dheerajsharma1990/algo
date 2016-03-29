package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MergeInvtervalTest {

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
    }

    public ArrayList<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start == i2.start ? i1.end - i2.end : i1.start - i2.start;
            }
        });

        ArrayList<Interval> ans = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()) {
            Interval interval = intervals.get(i);
            int start = interval.start;
            int end = interval.end;
            i++;
            while (i < intervals.size() && intervals.get(i).start <= end) {
                if (intervals.get(i).end > end) {
                    end = intervals.get(i).end;
                }
                i++;
            }
            ans.add(new Interval(start, end));
        }

        return ans;
    }

    @Test
    public void shouldTestForVariousIntervals() {
        //then
        List<Interval> ans1 = merge(Arrays.asList(new Interval(3, 4), new Interval(1, 2)));
        List<Interval> ans2 = merge(Arrays.asList(new Interval(3, 4), new Interval(1, 3)));
        List<Interval> ans3 = merge(Arrays.asList(new Interval(1, 2), new Interval(1, 2)));
        List<Interval> ans4 = merge(Arrays.asList(new Interval(8, 10), new Interval(15, 18),new Interval(2,6),new Interval(1,3)));

        //then
        assertThat(ans1.size(), is(2));
        assertThat(ans2.size(), is(1));
        assertThat(ans3.size(), is(1));
        assertThat(ans4.size(), is(3));
        assertThat(ans2.iterator().next().start, is(1));
        assertThat(ans2.iterator().next().end, is(4));
        assertThat(ans3.iterator().next().start, is(1));
        assertThat(ans3.iterator().next().end, is(2));
    }


}
