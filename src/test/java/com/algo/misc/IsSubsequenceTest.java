package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IsSubsequenceTest {

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && c == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(isSubsequence("abc", "cbaebabacd"), is(true));
        assertThat(isSubsequence("axc", "ahbgdc"), is(false));
        assertThat(isSubsequence("abc", "abc"), is(true));
        assertThat(isSubsequence("b", "abc"), is(true));
        assertThat(isSubsequence("acb", "abc"), is(false));
    }
}
