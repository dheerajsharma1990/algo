package com.algo.linkedlist;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next = node.getNext();
        while (next != null) {
            curr.setItem(next.getItem());
            curr = next;
            next = next.getNext();
        }
        curr.setNext(null);
        node.setNext(null);
    }

}
