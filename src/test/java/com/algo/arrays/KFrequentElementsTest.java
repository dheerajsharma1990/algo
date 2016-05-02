package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KFrequentElementsTest {

    class Node implements Comparable<Node> {
        int value;
        int frequency;

        public Node(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            return other.frequency - frequency;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (!frequency.containsKey(num)) {
                frequency.put(num, 0);
            }
            frequency.put(num, frequency.get(num) + 1);
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(nodes.poll().value);
        }
        return ans;
    }

    @Test
    public void shouldGetKFrequentElements() {
        //when
        List<Integer> list = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

        //then
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
    }

    @Test
    public void shouldGetKFrequentElementsAllSameElements() {
        //when
        List<Integer> list = topKFrequent(new int[]{1, 1, 1}, 1);

        //then
        assertThat(list.size(), is(1));
        assertThat(list.get(0), is(1));
    }

    @Test
    public void shouldGetKFrequentElementsAllDistinctElements() {
        //when
        List<Integer> list = topKFrequent(new int[]{1, 2, 3}, 3);

        //then
        assertThat(list.size(), is(3));
    }
}
