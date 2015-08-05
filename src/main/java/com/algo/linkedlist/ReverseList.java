package com.algo.linkedlist;

public class ReverseList {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.getNext();

        while (next != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = next.getNext();
        }

        current.setNext(previous);

        return current;
    }
}
