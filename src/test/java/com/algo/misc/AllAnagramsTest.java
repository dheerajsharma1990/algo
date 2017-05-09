package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AllAnagramsTest {

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            if (!anagramMap.containsKey(ch)) {
                anagramMap.put(ch, 0);
            }
            anagramMap.put(ch, anagramMap.get(ch) + 1);
        }
        int patternLength = p.length();

        int currentLength = 0;
        Map<Character, Integer> state = new HashMap<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (!anagramMap.containsKey(ch)) {
                state.clear();
                currentLength = 0;
                j++;
                i = j;
            } else if (anagramMap.containsKey(ch) && state.containsKey(ch) && state.get(ch).equals(anagramMap.get(ch))) {
                while (s.charAt(i) != ch) {
                    state.put(s.charAt(i), state.get(s.charAt(i)) - 1);
                    currentLength--;
                    i++;
                }
                i++;
                j++;
            } else {
                if (!state.containsKey(ch)) {
                    state.put(ch, 0);
                }
                state.put(ch, state.get(ch) + 1);
                currentLength++;
                if (currentLength == patternLength) {
                    ans.add(i);
                    state.put(s.charAt(i), state.get(s.charAt(i)) - 1);
                    currentLength--;
                    i++;
                }
                j++;

            }
        }
        return ans;
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(findAnagrams("cbaebabacd", "abc").size(), is(2));
        assertThat(findAnagrams("abab", "ab").size(), is(3));
        assertThat(findAnagrams("abab", "a").size(), is(2));
    }
}
