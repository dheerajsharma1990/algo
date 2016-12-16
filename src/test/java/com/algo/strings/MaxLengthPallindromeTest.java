package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxLengthPallindromeTest {

    private int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        int count = 0;
        boolean oddIncluded = false;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                if (!oddIncluded) {
                    count++;
                    oddIncluded = true;
                }
            }
            count += (value / 2) * 2;
        }
        return count;
    }

    @Test
    public void shouldGetLongestPallindromeLenght() {
        //then
        assertThat(longestPalindrome("abccccdd"), is(7));
        assertThat(longestPalindrome("aa"), is(2));
        assertThat(longestPalindrome("aaa"), is(3));
        assertThat(longestPalindrome("a"), is(1));
        assertThat(longestPalindrome("ab"), is(1));
        assertThat(longestPalindrome("aba"), is(3));
    }


}
