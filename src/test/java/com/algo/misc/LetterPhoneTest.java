package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class LetterPhoneTest {
    public List<String> letterCombinations(String a) {
        Map<Character, String> map = new HashMap<>();
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "0");
        List<String> result = new ArrayList<>();
        combinations(a, map, result, 0, "");
        return result;
    }

    private void combinations(String string, Map<Character, String> map, List<String> result, int i, String partial) {
        if (i == string.length()) {
            if (!partial.isEmpty()) {
                result.add(partial);
            }
            return;
        }
        for (char ch : map.get(string.charAt(i)).toCharArray()) {
            combinations(string, map, result, i + 1, partial + ch);
        }
    }

    @Test
    public void shouldGetCorrectCombinations() {
        assertThat(letterCombinations("23"), hasItems("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assertThat(letterCombinations("2"), hasItems("a", "b", "c"));
    }
}
