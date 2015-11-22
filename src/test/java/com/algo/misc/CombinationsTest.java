package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CombinationsTest {
    public List<List<Integer>> subsets(List<Integer> a) {
        Collections.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        combinations(a, ans, 0, new ArrayList<Integer>());
        return ans;
    }

    private void combinations(List<Integer> a, List<List<Integer>> ans, int k, List<Integer> partial) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : partial) {
            list.add(i);
        }
        ans.add(list);
        for (int i = k; i < a.size(); i++) {
            partial.add(a.get(i));
            combinations(a, ans, i + 1, partial);
            partial.remove(partial.size() - 1);
        }
    }

    @Test
    public void shouldCreateSubsets() {
        assertThat(subsets(Arrays.asList(1, 2, 3)).size(), is(8));
        assertThat(subsets(Arrays.asList(1, 2)).size(), is(4));
        assertThat(subsets(Arrays.asList(1)).size(), is(2));
        assertThat(subsets(Arrays.asList(1, 2, 3, 4)).size(), is(16));
    }
}
