package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CombinationSumTest {

    class Combinations {

        private List<List<Integer>> combinations = new ArrayList<>();

        void addCombination(Combinations combinations) {
            if (combinations != null) {
                for (List<Integer> list : combinations.combinations) {
                    List<Integer> l = new ArrayList<>(list);
                    this.combinations.add(l);
                }
            }
        }

        void addNumberToAllCombinations(int num) {
            for (List<Integer> list : this.combinations) {
                list.add(num);
            }
        }

        void addCombination(List<Integer> list) {
            this.combinations.add(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Combinations[][] combinations = new Combinations[candidates.length + 1][target + 1];
        for (int i = 0; i <= candidates.length; i++) {
            for (int j = 0; j <= target; j++) {
                combinations[i][j] = new Combinations();
            }
        }
        for (int i = 1; i <= candidates.length; i++) {
            combinations[i][0].addCombination(Collections.emptyList());
        }

        for (int i = 1; i <= candidates.length; i++) {
            int candidate = candidates[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j - candidate >= 0) {
                    combinations[i][j].addCombination(combinations[i][j - candidate]);
                    combinations[i][j].addNumberToAllCombinations(candidate);
                }
                combinations[i][j].addCombination(combinations[i - 1][j]);
            }
        }

        return combinations[candidates.length][target].combinations;
    }

    @Test
    public void shouldGetVariousCombinations() {
        assertThat(combinationSum(new int[]{1}, 1).size(), is(1));
        assertThat(combinationSum(new int[]{2, 3, 6, 7}, 7).size(), is(2));
        assertThat(combinationSum(new int[]{1, 2, 3}, 4).size(), is(4));
    }
}
