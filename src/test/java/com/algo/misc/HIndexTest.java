package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HIndexTest {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(hIndex(new int[]{3, 0, 6, 1, 5}), is(3));
        assertThat(hIndex(new int[]{0, 0, 0, 0, 0}), is(0));
        assertThat(hIndex(new int[]{0, 0, 1, 0, 0}), is(1));
        assertThat(hIndex(new int[]{2, 2, 1, 0, 0}), is(2));
    }


}
