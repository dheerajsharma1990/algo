package com.algo.linkedlist;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MergeKListTest {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> a) {
        Queue<ListNode> queue = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for (int i = 0; i < a.size(); i++) {
            queue.add(a.get(i));
        }
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            ListNode x = queue.poll();
            ListNode node = new ListNode(x.val);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            if (x.next != null) {
                queue.add(x.next);
            }
        }
        return head;
    }

    @Test
    public void shouldMergeKSortedList() {
        assertThat(isEqual(mergeKLists(Arrays.asList(getList(1, 10, 20), getList(4, 11, 13), getList(3, 8, 9))),
                getList(1, 3, 4, 8, 9, 10, 11, 13, 20)), is(true));

        assertThat(isEqual(mergeKLists(Arrays.asList(getList(1, 10, 20), getList(4, 11, 13), getList(3, 8, 9))),
                getList(1, 3, 4, 8, 9, 10, 11, 13, 20)), is(true));
    }

    private ListNode getList(int... numbers) {
        ListNode head = null;
        ListNode current = null;
        for (int n : numbers) {
            ListNode l = new ListNode(n);
            if (head == null) {
                head = l;
                current = head;
            } else {
                current.next = l;
                current = l;
            }
        }
        return head;
    }

    private boolean isEqual(ListNode first, ListNode second) {
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }

}
