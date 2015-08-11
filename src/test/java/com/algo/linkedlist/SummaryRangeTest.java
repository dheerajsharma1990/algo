package com.algo.linkedlist;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SummaryRangeTest {

    private final SummaryRange summaryRange = new SummaryRange();

    @Test
    public void shouldCreateTwoRanges() {
        //when
        List<String> ranges = summaryRange.summaryRanges(new int[]{0, 1, 2, 4});

        //then
        assertThat(ranges.size(), is(2));
        assertThat(ranges.get(0), is("0->2"));
        assertThat(ranges.get(1), is("4"));
    }

    @Test
    public void shouldCreateIndependentRanges() {
        //when
        List<String> ranges = summaryRange.summaryRanges(new int[]{0, 2, 4, 6});

        //then
        assertThat(ranges.size(), is(4));
        assertThat(ranges.get(0), is("0"));
        assertThat(ranges.get(1), is("2"));
        assertThat(ranges.get(2), is("4"));
        assertThat(ranges.get(3), is("6"));
    }

    @Test
    public void shouldCreateSingleRange() {
        //when
        List<String> ranges = summaryRange.summaryRanges(new int[]{0, 1, 2, 3, 4});

        //then
        assertThat(ranges.size(), is(1));
        assertThat(ranges.get(0), is("0->4"));
    }
}