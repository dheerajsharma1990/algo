package com.algo.linkedlist;

public class LoopList {

    public ListNode getLoopNode(ListNode head) {
        ListNode intersection = getIntersectionNode(head);

        while (head != null && intersection != null && head != intersection) {
            head = head.getNext();
            intersection = intersection.getNext();
        }

        return intersection;
    }

    private ListNode getIntersectionNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second != null) {
            second = second.getNext() != null ? second.getNext().getNext() : null;
            if (first == second) {
                return first;
            }
            first = first.getNext();
        }

        return null;
    }

}
