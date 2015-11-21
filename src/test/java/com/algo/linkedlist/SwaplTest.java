package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwaplTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode next = a.next.next;
        ListNode second = a.next;
        second.next = a;
        a.next = swapPairs(next);
        return second;
    }

    public ListNode iterSwapPairs(ListNode a) {
        if (a == null) {
            return a;
        }
        ListNode first = a;
        ListNode second = first.next;
        ListNode head = null;
        ListNode prev = null;
        while (second != null) {
            ListNode third = second.next;
            second.next = first;
            first.next = third;
            if (head == null) {
                head = second;
            } else {
                prev.next = second;
            }
            prev = first;
            first = third;
            second = third == null ? null : third.next;
        }
        return head == null ? a : head;
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(iterSwapPairs(null), nullValue());
        assertThat(isEqual(iterSwapPairs(getList(1)), getList(1)), is(true));
        assertThat(isEqual(iterSwapPairs(getList(1, 2)), getList(2, 1)), is(true));
        assertThat(isEqual(iterSwapPairs(getList(1, 2, 3)), getList(2, 1, 3)), is(true));
        assertThat(isEqual(iterSwapPairs(getList(1, 2, 3, 4)), getList(2, 1, 4, 3)), is(true));
        assertThat(isEqual(iterSwapPairs(getList(1, 4, 3, 2, 5, 2)), getList(4, 1, 2, 3, 2, 5)), is(true));
        assertThat(isEqual(iterSwapPairs(getList(1, 2, 3, 4, 5)), getList(2, 1, 4, 3, 5)), is(true));
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
