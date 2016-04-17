package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CombinationsSumIITest {

    class Node {
        private List<List<Integer>> combinations = new ArrayList<>();


        private void addEmptyCombination() {
            combinations.add(new ArrayList<Integer>());
        }

        private Node addInteger(Integer integer) {
            Node n = new Node();
            for (List<Integer> combination : combinations) {
                List<Integer> list = new ArrayList<>();
                list.addAll(combination);
                list.add(integer);
                n.combinations.add(list);
            }
            return n;
        }

        private Node union(Node node) {
            Node n = new Node();
            n.combinations.addAll(combinations);
            n.combinations.addAll(node.combinations);
            return n;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Node[][] matrix = new Node[candidates.length + 1][target + 1];
        for (int i = 0; i < candidates.length + 1; i++) {
            Node node = new Node();
            node.addEmptyCombination();
            matrix[i][0] = node;
        }
        for (int i = 1; i <= target; i++) {
            matrix[0][i] = new Node();
        }
        for (int i = 1; i < candidates.length + 1; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= candidates[i - 1]) {
                    Node x = null;
                    if (matrix[i - 1][j - candidates[i - 1]] != null) {
                        x = matrix[i - 1][j - candidates[i - 1]].addInteger(candidates[i - 1]);
                    }
                    if (matrix[i - 1][j] != null) {
                        if (x == null) {
                            x = matrix[i - 1][j];
                        } else {
                            x = matrix[i - 1][j].union(x);
                        }
                    }
                    matrix[i][j] = x;
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        List<List<Integer>> ans = matrix[candidates.length][target].combinations;
        Set<List<Integer>> filteredList = new HashSet<>();
        for (List<Integer> integers : ans) {
            filteredList.add(integers);
        }
        return new ArrayList<>(filteredList);
    }

    @Test
    public void shouldGetAllCombinations() {
        List<List<Integer>> x = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        assertThat(x.size(), is(4));
        List<List<Integer>> y = combinationSum2(new int[]{3, 1, 1, 5, 2, 6, 7, 10}, 2);
        assertThat(y.size(), is(2));
        List<List<Integer>> z = combinationSum2(new int[]{4, 4, 2, 1, 4, 2, 2, 1, 3}, 6);
        assertThat(z.size(), is(5));
    }

}
