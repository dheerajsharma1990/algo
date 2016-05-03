package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxProductWordLengthTest {

    public int maxProduct(String[] words) {
        Map<String, Integer[]> listMap = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!listMap.containsKey(word)) {
                    listMap.put(word, new Integer[26]);
                }
                listMap.get(word)[ch - 'a'] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            Integer[] firstList = listMap.get(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                Integer[] secondList = listMap.get(words[j]);
                int k = 0;
                for (; k < 26; k++) {
                    if (firstList != null && secondList != null && firstList[k] != null && secondList[k] != null && firstList[k] == 1 && secondList[k] == 1) {
                        break;
                    }
                }
                if (k == 26) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    @Test
    public void shouldGetMaxProductLength() {
        assertThat(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}), is(16));
        assertThat(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}), is(4));
        assertThat(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}), is(0));
        assertThat(maxProduct(new String[]{"a"}), is(0));
        assertThat(maxProduct(new String[]{"a", "b"}), is(1));
        assertThat(maxProduct(new String[]{"abc", ""}), is(0));
    }
}
