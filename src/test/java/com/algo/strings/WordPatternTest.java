package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordPatternTest {
    public boolean wordPattern(String pattern, String str) {
        String splits[] = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> characterMap = new HashMap<>();
        int i = 0;
        for (; i < pattern.length() && i < splits.length; i++) {
            Character character = pattern.charAt(i);
            if (map.containsKey(character)) {
                if (!map.get(character).equals(splits[i])) {
                    return false;
                }
            } else {
                if (characterMap.containsKey(splits[i])) {
                    return false;
                }
                map.put(character, splits[i]);
                characterMap.put(splits[i], character);
            }
        }
        return i == splits.length && i == pattern.length();
    }

    @Test
    public void shouldMatchWordPattern() {
        assertThat(wordPattern("jquery", "jquery"), is(false));
        assertThat(wordPattern("aaa", "aa aa aa aa"), is(false));
        assertThat(wordPattern("abba", "dog cat cat dog"), is(true));
        assertThat(wordPattern("abba", "dog cat cat fish"), is(false));
        assertThat(wordPattern("aaaa", "dog cat cat dog"), is(false));
        assertThat(wordPattern("abba", "dog dog dog dog"), is(false));
    }
}
