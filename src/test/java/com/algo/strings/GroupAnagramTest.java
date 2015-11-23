package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupAnagramTest {
    public List<List<Integer>> anagrams(final List<String> a) {
        List<List<Integer>> lists = new ArrayList<>();
        List<String> sorted = new ArrayList<>();
        for (String string : a) {
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            sorted.add(String.valueOf(arr));
        }
        Map<String, List<Integer>> groups = new TreeMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            String str = sorted.get(i);
            if (!groups.containsKey(str)) {
                groups.put(str, new ArrayList<Integer>());
            }
            groups.get(str).add(i + 1);
        }
        Set<String> checked = new HashSet<>();
        for (String str : sorted) {
            if (!checked.contains(str)) {
                lists.add(groups.get(str));
                checked.add(str);
            }
        }
        return lists;
    }

    @Test
    public void shouldGroupAnagrams() {
        assertThat(anagrams(Arrays.asList("cat", "bat", "dog", "god", "tca", "are", "rea", "tab", "bta")).size(), is(2));
    }
}
