package com.algo.strings;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringPermutationTest {

    public List<List<Integer>> permute(List<Integer> a) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans, a, 0, a.size() - 1);
        return ans;
    }

    private void permute(List<List<Integer>> ans, List<Integer> a, int start, int end) {
        if (start == end) {
            List<Integer> mid = new ArrayList<>();
            mid.addAll(a);
            ans.add(mid);
            return;
        }

        for (int k = start; k <= end; k++) {
            swap(a, start, k);
            permute(ans, a, start + 1, end);
            swap(a, start, k);
        }

    }

    private void swap(List<Integer> a, int i, int j) {
        int k = a.get(i);
        a.set(i, a.get(j));
        a.set(j, k);
    }

    @Test
    public void shouldGetCorrectPermutations() {
        assertThat(permute(Arrays.asList(1, 2, 3)).size(), is(6));
    }
}
