package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlternateKReverseTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseAlternateKList(ListNode listNode, int k) {
        return reverse(listNode, k, true);
    }

    private ListNode reverse(ListNode listNode, int k, boolean reverse) {
        if (listNode == null) {
            return null;
        }
        int l = k;
        if (reverse) {
            ListNode previous = null;
            ListNode current = listNode;
            ListNode next = current;

            while (next != null && l > 0) {
                next = next.next;
                current.next = previous;
                previous = current;
                current = next;
                l--;
            }
            listNode.next = reverse(next, k, !reverse);
            return previous;
        } else {
            ListNode current = listNode;
            while (current != null && l > 1) {
                current = current.next;
                l--;
            }
            if (current != null) {
                current.next = reverse(current.next, k, !reverse);
            }
            return listNode;
        }
    }

    @Test
    public void shouldHaveSameListForK1() {
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3), 1), getList(1, 2, 3)), is(true));
    }

    @Test
    public void shouldReverseAlternateForK2() {
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3), 2), getList(2, 1, 3)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1, 2), 2), getList(2, 1)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3, 4), 2), getList(2, 1, 3, 4)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3, 4), 3), getList(3, 2, 1, 4)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3, 4), 4), getList(4, 3, 2, 1)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1), 1), getList(1)), is(true));
        assertThat(isEqual(reverseAlternateKList(getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3), getList(3, 2, 1, 4, 5, 6, 9, 8, 7, 10)), is(true));
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
