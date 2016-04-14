package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SuperUglyNumberTest {

    class Node implements Comparable<Node> {
        int result;
        int prime;
        int index;

        public Node(int result, int prime, int index) {
            this.result = result;
            this.prime = prime;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return result - o.result;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            priorityQueue.add(new Node(primes[i] * 1, primes[i], 0));
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int i = 1;
        Node result = null;
        while (i < n) {
            result = priorityQueue.poll();
            if (result.result == ans.get(ans.size() - 1)) {
                priorityQueue.add(new Node(result.prime * ans.get(result.index + 1), result.prime, result.index + 1));
            } else {
                ans.add(result.result);
                priorityQueue.add(new Node(result.prime * ans.get(result.index + 1), result.prime, result.index + 1));
                i++;
            }
        }
        return n == 1 ? 1 : result.result;
    }

    @Test
    public void shouldProduceSuperUglyNumber() {
        assertThat(nthSuperUglyNumber(1, new int[]{2, 7, 13, 19}), is(1));
        assertThat(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}), is(32));
        assertThat(nthSuperUglyNumber(100, new int[]{2, 7, 13, 19}), is(5408));
        assertThat(nthSuperUglyNumber(8, new int[]{2, 3}), is(12));
        assertThat(nthSuperUglyNumber(35, new int[]{2, 7, 13, 19}), is(338));
        assertThat(nthSuperUglyNumber(100, new int[]{2, 7, 13, 19}), is(5408));
        assertThat(nthSuperUglyNumber(200, new int[]{2, 7, 13, 19}), is(57344));
    }
}

