package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RepeatStrTest {

    public int lengthOfLongestSubstring(String a) {
        Set<Character> visited = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = 0;
        int maxLen = 0;
        while (j < a.length()) {
            if (!visited.contains(a.charAt(j))) {
                len++;
                visited.add(a.charAt(j));
                j++;
            } else {
                maxLen = maxLen > len ? maxLen : len;
                while (a.charAt(i) != a.charAt(j)) {
                    visited.remove(a.charAt(i));
                    i++;
                    len--;
                }
                visited.remove(a.charAt(i++));
                len--;
            }
        }
        maxLen = maxLen > len ? maxLen : len;
        return maxLen;
    }

    @Test
    public void shouldReturnLengthOfLongestNonRepeatingSubstring() {
        assertThat(lengthOfLongestSubstring("abcabcbb"), is(3));
        assertThat(lengthOfLongestSubstring("bbbb"), is(1));
        assertThat(lengthOfLongestSubstring("geeksforgeeks"), is(7));
        assertThat(lengthOfLongestSubstring("u"), is(1));
    }
}
