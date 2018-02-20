package com.algo.strings;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LongestThroughDescriptionTest {

    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String string : d) {
            int idx = string.length() - 1;
            for (int i = s.length() - 1; i >= 0 && idx > -1; i--) {
                if (s.charAt(i) == string.charAt(idx)) {
                    idx--;
                }
            }
            if (idx == -1) {
                ans = string.length() == ans.length() ? ans.compareTo(string) < 0 ? ans : string : string.length() > ans.length() ? string : ans;
            }
        }
        return ans;
    }

    @Test
    public void shouldGetLongestString() {
        assertThat(findLongestWord("aaa", Arrays.asList("aaa", "aa", "a")), is("aaa"));
        assertThat(findLongestWord("abpcplea", Arrays.asList("b", "a", "c")), is("a"));
        assertThat(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")), is("apple"));
    }
}
