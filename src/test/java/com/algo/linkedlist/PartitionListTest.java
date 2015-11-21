package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PartitionListTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode a, int b) {
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode firstLast = null;
        ListNode secondLast = null;
        for (ListNode l = a; l != null; l = l.next) {
            if (l.val < b) {
                if (firstLast == null) {
                    firstNode = l;
                } else {
                    firstLast.next = l;
                }
                firstLast = l;
            } else {
                if (secondLast == null) {
                    secondNode = l;
                } else {
                    secondLast.next = l;
                }
                secondLast = l;
            }

        }

        if (firstNode != null) {
            firstLast.next = secondNode;
        }
        if (secondLast != null) {
            secondLast.next = null;
        }

        return firstNode != null ? firstNode : secondNode;
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(isEqual(partition(getList(1, 4, 3, 2, 5, 2), 3), getList(1, 2, 2, 4, 3, 5)), is(true));
        assertThat(isEqual(partition(getList(6, 5, 4, 3, 2, 1), 7), getList(6, 5, 4, 3, 2, 1)), is(true));
        assertThat(isEqual(partition(getList(1, 2, 3, 4, 5, 6), 0), getList(1, 2, 3, 4, 5, 6)), is(true));
        assertThat(isEqual(partition(getList(1), 2), getList(1)), is(true));
        assertThat(isEqual(partition(getList(1), 1), getList(1)), is(true));
        assertThat(isEqual(partition(getList(1), 0), getList(1)), is(true));
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
