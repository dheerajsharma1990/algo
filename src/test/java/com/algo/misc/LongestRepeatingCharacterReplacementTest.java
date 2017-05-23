package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongestRepeatingCharacterReplacementTest {

    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int i = 0;
            int j = 0;
            int count = 0;
            int used = 0;
            while (j < s.length()) {
                if (s.charAt(j) == ch) {
                    count++;
                    j++;
                    continue;
                } else {
                    if (used < k) {
                        used++;
                        count++;
                        j++;
                    } else {
                        max = Math.max(max, count);
                        if (s.charAt(i) == ch) {
                            while (s.charAt(i) == ch) {
                                i++;
                                count--;
                            }
                        } else {
                            i++;
                            j++;
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    public void shouldGetCountOfOnes() {
        //then
        assertThat(characterReplacement("AABAB", 2), is(5));
        assertThat(characterReplacement("AABAB", 1), is(4));
        assertThat(characterReplacement("AABAB", 6), is(5));
        assertThat(characterReplacement("ABBABABBBAB", 1), is(5));
        assertThat(characterReplacement("ABBABABBBAB", 0), is(3));
        assertThat(characterReplacement("AAAB", 3), is(4));
        assertThat(characterReplacement("AAABAA", 3), is(6));
    }
}
