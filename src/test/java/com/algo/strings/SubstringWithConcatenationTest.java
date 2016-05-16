package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SubstringWithConcatenationTest {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }
        int wordLength = map.keySet().iterator().next().length();

        boolean[] ans = new boolean[s.length()];
        for (int i = 0; i < wordLength; i++) {
            int j = i;
            int k = j;
            int countTillNow = 0;
            while ((k + wordLength) <= s.length()) {
                String subString = s.substring(k, k + wordLength);
                if (map.containsKey(subString) && map.get(subString) > 0) {
                    map.put(subString, map.get(subString) - 1);
                    countTillNow++;
                    if (countTillNow == words.length) {
                        ans[j] = true;
                        String sub = s.substring(j, j + wordLength);
                        map.put(sub, map.get(sub) + 1);
                        j = j + wordLength;
                        countTillNow--;
                    }
                    k = k + wordLength;
                } else {
                    if (j != k) {
                        String sub = s.substring(j, j + wordLength);
                        map.put(sub, map.get(sub) + 1);
                        j = j + wordLength;
                        countTillNow--;
                    } else {
                        k = k + wordLength;
                        j = k;
                        countTillNow = 0;
                    }
                }
            }
            map.clear();
            for (String word : words) {
                if (!map.containsKey(word)) {
                    map.put(word, 0);
                }
                map.put(word, map.get(word) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i]) {
                list.add(i);
            }
        }
        return list;
    }

    @Test
    public void shouldGetSubStringConcatenationIndexes() {
        assertThat(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}), is(Arrays.asList(0, 9)));
        assertThat(findSubstring("barfoothefoobarman", new String[]{"foo"}), is(Arrays.asList(3, 9)));
        assertThat(findSubstring("barfoothefoobarman", new String[]{"xyz"}).isEmpty(), is(true));
        assertThat(findSubstring("a", new String[]{"xyz"}).isEmpty(), is(true));
        assertThat(findSubstring("xyz", new String[]{"xyz"}), is(Arrays.asList(0)));
        assertThat(findSubstring("xyzxyz", new String[]{"xyz"}), is(Arrays.asList(0, 3)));
        assertThat(findSubstring("aaaaa", new String[]{"a", "a"}), is(Arrays.asList(0, 1, 2, 3)));
        assertThat(findSubstring("aaaaa", new String[]{"a", "b"}).isEmpty(), is(true));
        assertThat(findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}), is(Arrays.asList(0, 1, 2)));
        assertThat(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}), is(Arrays.asList(6, 9, 12)));
    }
}
