package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordBreakTest {

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];
        arr[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (!arr[i]) {
                continue;
            }
            for (String word : wordDict) {
                int length = word.length();
                if (i + length <= s.length()) {
                    String subString = s.substring(i, i + length);
                    if (subString.equals(word)) {
                        arr[i + length] = true;
                    }
                }
            }

        }
        return arr[s.length()];
    }

    @Test
    public void shouldBreakWords() {
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code"))), is(true));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("l", "e", "t", "c", "o", "d"))), is(true));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("l", "e", "t", "c", "o"))), is(false));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("leetcode"))), is(true));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("leetcodes"))), is(false));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("le", "lee", "et", "t", "co", "cod", "e"))), is(true));
        assertThat(wordBreak("leetcode", new HashSet<>(Arrays.asList("le", "lee", "et", "co", "cod", "e"))), is(true));
    }
}
