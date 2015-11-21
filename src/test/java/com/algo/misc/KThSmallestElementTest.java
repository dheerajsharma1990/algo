package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KThSmallestElementTest {

    public int kthsmallest(final List<Integer> a, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(a.get(i));
        }
        for (int i = k; i < a.size(); i++) {
            if (a.get(i) <= queue.peek()) {
                queue.remove();
                queue.offer(a.get(i));
            }
        }

        return queue.poll();
    }

    @Test
    public void shouldGetKthSmallest() {
        assertThat(kthsmallest(Arrays.asList(9, 4, 5, 1, 7, 3, 10, 6), 4), is(5));
        assertThat(kthsmallest(Arrays.asList(4, 1, 3, 2), 2), is(2));
        assertThat(kthsmallest(Arrays.asList(1), 1), is(1));
        assertThat(kthsmallest(Arrays.asList(2, 1), 2), is(2));
        assertThat(kthsmallest(Arrays.asList(2, 1), 1), is(1));
    }
}
