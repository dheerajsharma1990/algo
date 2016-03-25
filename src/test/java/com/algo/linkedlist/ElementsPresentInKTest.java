package com.algo.linkedlist;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsPresentInKTest {

    private List<Integer> presentInK(List<List<Integer>> lists, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (Integer integer : list) {
                if (!map.containsKey(integer)) {
                    map.put(integer, new HashSet<Integer>());
                }
                map.get(integer).add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    @Test
    public void shouldReturnCorrectAnswerForVariousScenarios() {
        //when
        List<Integer> ans = presentInK(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(2, 3)), 2);

        //then
        assertThat(ans.size(), is(2));
        Collections.sort(ans);
        assertThat(ans.get(0), is(2));
        assertThat(ans.get(1), is(3));
    }

}