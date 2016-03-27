package com.algo.strings;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PatternMatchingTest {

    private boolean isMatching(String string, String pattern) {
        return isMatching(string, pattern, 0, 0);
    }

    private boolean isMatching(String string, String pattern, int i, int j) {
        if (i == string.length() && j == pattern.length()) {
            return true;
        }
        if (i == string.length() || j == pattern.length()) {
            return false;
        }
        if (pattern.charAt(j) == '.') {
            return isMatching(string, pattern, i + 1, j + 1);
        }
        if (pattern.charAt(j) != '*') {
            if (pattern.charAt(j) != string.charAt(i)) {
                return false;
            } else {
                return isMatching(string, pattern, i + 1, j + 1);
            }
        }
        return isMatching(string, pattern, i + 1, j) || isMatching(string, pattern, i + 1, j + 1);
    }

    @Test
    public void shouldTestVariousScenarios() {
        //then
        assertThat(isMatching("abc", "abc"), is(true));
        assertThat(isMatching("abc", "ab."), is(true));
        assertThat(isMatching("abc", "a*"), is(true));
        assertThat(isMatching("abc", "a.."), is(true));
        assertThat(isMatching("abc", "a.d"), is(false));
        assertThat(isMatching("abc", "a*d"), is(false));
        assertThat(isMatching("abbbbc", "a*.b.c"), is(true));
        assertThat(isMatching("aaa", "..."), is(true));
        assertThat(isMatching("aaa", "*"), is(true));
        assertThat(isMatching("aaa", ".*"), is(true));
        assertThat(isMatching("aaa", "...*"), is(false));
        assertThat(isMatching("aaab", "...*"), is(true));
        assertThat(isMatching("aaab", ".*.*"), is(true));
    }
}
