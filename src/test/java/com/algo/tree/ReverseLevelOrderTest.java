package com.algo.tree;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class ReverseLevelOrderTest {

    public List<List<Integer>> getReverseOrder(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
        queue.add(-2);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            if (pop == -2) {
                List<Integer> newList = new ArrayList<>();
                if (!list.isEmpty()) {
                    answer.add(0, list);
                    list = newList;
                    queue.add(-2);
                }
            } else {
                if (map.containsKey(pop)) {
                    for (Integer integer : map.get(pop)) {
                        queue.add(integer);
                        list.add(integer);
                    }
                }
            }
        }
        return answer;
    }

    @Test
    public void shouldReturnCorrectResultsForVariousScenarios() {
        List<List<Integer>> ans = getReverseOrder(new int[]{3, 3, 4, 4, -1});

        assertThat(ans.size(), is(3));
        assertThat(ans.get(0), hasItems(0, 1));
        assertThat(ans.get(1), hasItems(2, 3));
        assertThat(ans.get(2), hasItems(4));
    }

}
