package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNumTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode current = null;
        int carry = 0;
        while (a != null && b != null) {
            int sum = a.val + b.val;
            ListNode node = new ListNode((sum + carry) % 10);
            carry = (sum + carry) / 10;
            if (head == null) {
                head = node;
            } else {
                current.next = node;
            }
            current = node;
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            ListNode node = new ListNode((a.val + carry) % 10);
            carry = (a.val + carry) / 10;
            if (head == null) {
                head = node;
            } else {
                current.next = node;
            }
            current = node;
            a = a.next;
        }

        while (b != null) {
            ListNode node = new ListNode((b.val + carry) % 10);
            carry = (b.val + carry) / 10;
            if (head == null) {
                head = node;
            } else {
                current.next = node;
            }
            current = node;
            b = b.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return head;

    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(isEqual(addTwoNumbers(getList(2, 4, 3), getList(5, 6, 4)), getList(7, 0, 8)), is(true));
        assertThat(isEqual(addTwoNumbers(getList(9, 9), getList(1)), getList(0, 0, 1)), is(true));
        assertThat(isEqual(addTwoNumbers(getList(9, 9, 9, 9), getList(1)), getList(0, 0, 0, 0, 1)), is(true));
        assertThat(isEqual(addTwoNumbers(getList(0, 0, 1), getList(0, 0, 1)), getList(0, 0, 2)), is(true));
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
