package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringDuplicateCheckTest {

    public int getDistinctWordsCount(String words) {
        words = words.replaceAll(" +"," ").trim();
        String[] allWords = words.split(" +");
        Set<String> distinctWords = new HashSet<>(Arrays.asList(allWords));
        return distinctWords.size();
    }

    @Test
    public void shouldGetDistinctWordsCount() {
        assertThat(getDistinctWordsCount(" ab bc  bc"), is(2));
        assertThat(getDistinctWordsCount(" ab bc  bc  "), is(2));
        assertThat(getDistinctWordsCount("abbc  bc  "), is(2));
        assertThat(getDistinctWordsCount("abbc"), is(1));
        assertThat(getDistinctWordsCount(""), is(0));
    }

}
