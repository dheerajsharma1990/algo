package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AdjacentAnagramsTest {

    private List<String> adjacentAnagrams(List<String> strings) {
        List<String> ans = new ArrayList<>();
        if (!strings.isEmpty()) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            populateMap(strings.get(0), map1);
            for (int i = 1; i < strings.size(); i++) {
                String string = strings.get(i);
                populateMap(string, map2);
                if (areEqual(map1, map2)) {
                    ans.add(string);
                }
                Map<Character, Integer> temp = map1;
                map1 = map2;
                map2 = temp;
                map2.clear();
            }

        }
        return ans;
    }

    private boolean areEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character character : map1.keySet()) {
            if (!map2.containsKey(character) || map2.get(character) != map1.get(character)) {
                return false;
            }
        }
        return map1.size() == map2.size();
    }

    private void populateMap(String string, Map<Character, Integer> map) {
        for (Character character : string.toCharArray()) {
            if (!map.containsKey(character)) {
                map.put(character, 0);
            }
            map.put(character, map.get(character) + 1);
        }
    }

    @Test
    public void shouldReturnAdjacentAnagrams() {
        //when
        List<String> strings = adjacentAnagrams(Arrays.asList("abc", "cbd", "dbc", "acd", "cda", "dac"));

        //then
        assertThat(strings.size(), is(3));
        assertThat(strings.get(0), is("dbc"));
        assertThat(strings.get(1), is("cda"));
        assertThat(strings.get(2), is("dac"));
    }
}
