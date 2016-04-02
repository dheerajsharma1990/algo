package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CombinationSum3Test {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k <= 9 || n > 45) {
            combinations(lists, new ArrayList<Integer>(), 1, k, n, 0);
        }

        return lists;
    }

    private void combinations(List<List<Integer>> ans, List<Integer> integers, int i, int k, int n, int sum) {
        if (sum > n) {
            return;
        }
        if (k == integers.size()) {
            if (n == sum) {
                List<Integer> mid = new ArrayList<>();
                mid.addAll(integers);
                ans.add(mid);
            }
            return;
        }
        for (int p = i; p <= 9; p++) {
            integers.add(p);
            combinations(ans, integers, p + 1, k, n, sum + p);
            integers.remove(integers.size() - 1);
        }

    }

    @Test
    public void shouldGetCombinations() {
        List<List<Integer>> ans = combinationSum3(9, 45);
        assertThat(ans.size(), is(1));
    }
}
