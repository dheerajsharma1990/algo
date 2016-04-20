package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DuplicateSubSetsTest {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> all = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            generateWithKCombinations(nums, 0, i, new ArrayList<Integer>(), all);
        }
        return new ArrayList<>(all);
    }

    private void generateWithKCombinations(int[] nums, int i, int k, List<Integer> ans, Set<List<Integer>> all) {
        if (k == 0) {
            List<Integer> mid = new ArrayList<>();
            mid.addAll(ans);
            all.add(mid);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            ans.add(nums[j]);
            generateWithKCombinations(nums, j + 1, k - 1, ans, all);
            ans.remove(ans.size() - 1);
        }
    }

    @Test
    public void shouldGenerateNonDuplicateSets() {
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 2});
        List<List<Integer>> lists1 = subsetsWithDup(new int[]{2, 1, 2, 1, 3});
        assertThat(lists.size(), is(6));
        assertThat(lists1.size(), is(18));
    }

}
