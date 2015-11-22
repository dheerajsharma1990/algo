package com.algo.strings;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class PalindromePartitionTest {

    public List<List<String>> partition(String a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {
                if (isPalin(a, i, j)) {
                    if (!map.containsKey(i)) {
                        map.put(i, new ArrayList<Integer>());
                    }
                    map.get(i).add(j);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        populate(ans, map, new ArrayList<String>(), a, 0);
        return ans;
    }

    private void populate(List<List<String>> ans, Map<Integer, List<Integer>> map, List<String> temp, String a, int i) {
        if (i == a.length()) {
            List<String> copy = new ArrayList<>();
            copy.addAll(temp);
            ans.add(copy);
            return;
        }

        for (int x : map.get(i)) {
            temp.add(a.substring(i, x + 1));
            populate(ans, map, temp, a, x + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isPalin(String a, int i, int j) {
        while (i < j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void shouldPartitionPalindromeCorrectly() {
        assertThat(partition("aab").get(0), hasItems("a", "a", "b"));
        assertThat(partition("aab").get(1), hasItems("aa", "b"));
        assertThat(partition("aaaa").get(0), hasItems("a", "a", "a", "a"));
        assertThat(partition("aaaa").get(1), hasItems("a", "aa", "a"));
        assertThat(partition("geeksforgeeks").get(1), hasItems("a", "aa", "a"));
    }

}
