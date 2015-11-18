package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LargestNumTest {

    public String largestNumber(final List<Integer> a) {
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String x = o1.toString();
                String y = o2.toString();
                return Long.valueOf(x + y) > Long.valueOf(y + x) ? -1 : 1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer x : a) {
            builder.append(x);
        }
        String s = builder.toString();
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i).isEmpty() ? "0" : s.substring(i);
    }

    @Test
    public void shouldReturnCorrectResultForVariousInputs() {
        //then
        assertThat(largestNumber(Arrays.asList(3, 30, 34, 5, 9)), is("9534330"));
        assertThat(largestNumber(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)), is("9876543210"));
        assertThat(largestNumber(Arrays.asList(123, 45, 6, 7, 8, 90)), is("9087645123"));
        assertThat(largestNumber(Arrays.asList(90, 801, 7012, 0, 210, 11)), is("908017012210110"));
        assertThat(largestNumber(Arrays.asList(0, 0, 0)), is("0"));
        assertThat(largestNumber(Arrays.asList(0, 0, 1, 1)), is("1100"));
        assertThat(largestNumber(Arrays.asList(12, 121)), is("12121"));
        assertThat(largestNumber(Arrays.asList(3, 34, 30)), is("34330"));
    }
}
