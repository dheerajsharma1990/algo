package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LenghtLastTest {

    public int lengthOfLastWord(final String a) {
        int i = a.length() - 1;
        while (i >= 0 && a.charAt(i) == ' ') {
            i--;
        }
        int j = i;
        while (j >= 0 && a.charAt(j) != ' ') {
            j--;
        }
        return i - j;
    }

    @Test
    public void shouldCheckForPalindromes() {
        assertThat(lengthOfLastWord(" a "), is(1));
        assertThat(lengthOfLastWord("race a car"), is(3));
        assertThat(lengthOfLastWord("rac1 1 car "), is(3));
        assertThat(lengthOfLastWord(" dheeraj "), is(7));
        assertThat(lengthOfLastWord(" dheeraj"), is(7));
        assertThat(lengthOfLastWord("dheeraj"), is(7));
    }
}
