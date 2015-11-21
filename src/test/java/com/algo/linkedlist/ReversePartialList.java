package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReversePartialList {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null) {
            return a;
        }
        ListNode x = new ListNode(-1);
        x.next = a;
        ListNode firstTail = x;
        for (int i = 0; i < m - 1; i++) {
            firstTail = firstTail.next;
        }
        ListNode head = firstTail.next;
        firstTail.next = null;
        ListNode secondTail = head;
        for (int i = 0; i < n - m; i++) {
            secondTail = secondTail.next;
        }
        ListNode thirdHead = secondTail.next;
        secondTail.next = null;

        ListNode nT = null;
        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;
        while (next != null) {
            current.next = previous;
            if (nT == null) {
                nT = current;
            }
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        firstTail.next = current;
        if (nT == null) {
            nT = current;
        }
        nT.next = thirdHead;
        a = x.next;
        x.next = null;
        return a;
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(isEqual(reverseBetween(getList(1), 1, 1), getList(1)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2), 1, 1), getList(1, 2)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2), 1, 2), getList(2, 1)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2, 3), 1, 2), getList(2, 1, 3)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2, 3), 1, 3), getList(3, 2, 1)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2, 3), 1, 1), getList(1, 2, 3)), is(true));
        assertThat(isEqual(reverseBetween(getList(1, 2, 3), 2, 3), getList(1, 3, 2)), is(true));
        //assertThat(isEqual(reverseBetween(getList(1, 2, 3, 4), 2, 3), getList(1, 3, 2, 4)), is(true));
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
