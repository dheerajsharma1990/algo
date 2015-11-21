package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PalinTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        ListNode x = A;
        ListNode y = A;
        while (y != null && y.next != null && y.next.next != null) {
            x = x.next;
            y = y.next.next;
        }
        ListNode head = x.next;
        x.next = null;

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        for (ListNode l = current, p = A; l != null; l = l.next, p = p.next) {
            if (l.val != p.val) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void shouldCheckForPalindrome() {
        assertThat(lPalin(null), is(1));
        assertThat(lPalin(new ListNode(1)), is(1));
        ListNode l = new ListNode(1);
        l.next =  new ListNode(2);
        assertThat(lPalin(l), is(0));
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        assertThat(lPalin(l), is(1));
    }

    @Test
    public void shouldCheckPalindromeForLongList() {
        ListNode listNode = new ListNode(6);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(6);
        assertThat(lPalin(listNode), is(1));
    }
}
