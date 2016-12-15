package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringDuplicateCheckTest {

    private int getDistinctWordsCount(String words) {
        return (int) Arrays.stream(words.split(" "))
                .filter(s -> !s.isEmpty())
                .distinct()
                .count();
    }

    @Test
    public void shouldGetDistinctWordsCount() {
        assertThat(getDistinctWordsCount("  ab bc bc  "), is(2));
        assertThat(getDistinctWordsCount(" ab bc   bc "), is(2));
        assertThat(getDistinctWordsCount(" abbc bc  "), is(2));
        assertThat(getDistinctWordsCount("abbc"), is(1));
        assertThat(getDistinctWordsCount(""), is(0));
    }

}
