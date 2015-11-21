package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubtractListTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode subtract(ListNode a) {

        ListNode first = a;
        ListNode second = a;
        while (first != null && second != null && second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }

        ListNode head1 = a;
        ListNode head2 = first.next;
        first.next = null;

        head2 = reverse(head2);


        second = head2;
        while (second != null) {
            head1.val = second.val - head1.val;
            head1 = head1.next;
            second = second.next;
        }

        head2 = reverse(head2);
        first.next = head2;
        return a;
    }

    private ListNode reverse(ListNode head2) {
        ListNode previous = null;
        ListNode current = head2;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head2 = previous;
        return head2;
    }

    @Test
    public void shouldSubtractList() {
        assertThat(isEqual(subtract(getList(1)), getList(1)), is(true));
        assertThat(isEqual(subtract(getList(1, 3)), getList(2, 3)), is(true));
        assertThat(isEqual(subtract(getList(1, 3, 4)), getList(3, 3, 4)), is(true));
        assertThat(isEqual(subtract(getList(1, 3, 4, 2)), getList(1, 1, 4, 2)), is(true));
        assertThat(isEqual(subtract(getList(1, 3, 4, 2, 5)), getList(4, -1, 4, 2, 5)), is(true));
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
