package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class RemoveDuplicatesTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }


    }

    public ListNode deleteDuplicates(ListNode a) {
        if (a.next == null) {
            return a;
        }
        ListNode previous = null;
        ListNode head = previous;
        ListNode current = a;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (current.val == next.val) {
                while (next != null && current.val == next.val) {
                    next = next.next;
                }
                if (previous != null) {
                    previous.next = next;
                } else {
                    if (head == null) {
                        head = previous;
                    }
                }
                current = next;
            } else {
                previous = current;
                if (head == null) {
                    head = previous;
                }
                current = current.next;
            }

        }
        return head;
    }

    @Test
    public void shouldTestOnVariousLinkedList() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        assertThat(deleteDuplicates(node), notNullValue());
    }

    @Test
    public void shouldTestOnVariousLinkedListAllSame() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(1);
        assertThat(deleteDuplicates(node), nullValue());
    }

    @Test
    public void shouldTestOnVariousLinkedStartingDifferent() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        assertThat(deleteDuplicates(node), notNullValue());
    }

    @Test
    public void shouldTestOnVariousLinkedAllDuplicated() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(3);
        assertThat(deleteDuplicates(node), nullValue());
    }
}
