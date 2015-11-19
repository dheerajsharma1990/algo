package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HotelTest {

    class Day implements Comparable<Day> {
        private int start;
        private int end;

        public Day(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Day day) {
            return start == day.start ? (end < day.end ? -1 : 1)
                    : start < day.start ? -1 : 1;
        }

        public boolean isStartEndEqual() {
            return start == end;
        }
    }

    class EndDay implements Comparable<EndDay> {
        private int endDay;

        public EndDay(int endDay) {
            this.endDay = endDay;
        }

        @Override
        public int compareTo(EndDay e) {
            return endDay > e.endDay ? 1 : -1;
        }
    }

    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        Day[] days = new Day[arrive.size()];
        for (int i = 0; i < arrive.size(); i++) {
            days[i] = new Day(arrive.get(i), depart.get(i));
        }
        Arrays.sort(days);
        --K;
        Queue<EndDay> occ = new PriorityQueue<>();
        occ.add(new EndDay(days[0].end));
        for (int i = 1; i < days.length; i++) {
            for (int j = 0; j < occ.size(); j++) {
                while (occ.size() != 0 && occ.peek().endDay <= days[i].start) {
                    occ.remove();
                    ++K;
                }
            }
            if (!days[i].isStartEndEqual()) {
                occ.add(new EndDay(days[i].end));
                --K;
            }
            if (K < 0) {
                return false;
            }
        }
        return !(K < 0);
    }

    @Test
    public void shouldReturnFalseForZeroRoom() {
        //then
        assertThat(hotel(Arrays.asList(2, 3, 3, 1, 4, 1), Arrays.asList(3, 4, 4, 2, 5, 3), 0), is(false));
        assertThat(hotel(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 4, 5), 1), is(true));
        assertThat(hotel(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 5, 5), 1), is(false));
        assertThat(hotel(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 5, 5), 1), is(false));
        assertThat(hotel(Arrays.asList(1, 3, 5), Arrays.asList(2, 6, 8), 1), is(false));
        assertThat(hotel(Arrays.asList(40, 18), Arrays.asList(40, 43), 1), is(true));
        assertThat(hotel(Arrays.asList(9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27),
                Arrays.asList(32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38), 16), is(true));
    }
}
