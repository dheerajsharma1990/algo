package com.algo.linkedlist;

public class PalindromeList {

    private final ReverseList reverseList;

    public PalindromeList(ReverseList reverseList) {
        this.reverseList = reverseList;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode clone = clone(head);
        ListNode reverse = reverseList.reverse(head);
        while (clone != null && reverse != null) {
            if (!clone.getItem().equals(reverse.getItem())) {
                return false;
            }
            clone = clone.getNext();
            reverse = reverse.getNext();
        }
        return clone == null && reverse == null;
    }

    private ListNode clone(ListNode head) {
        ListNode newHead = null;
        ListNode tail = null;
        for (; head != null; head = head.getNext()) {
            ListNode node = new ListNode(head.getItem());
            if (newHead == null) {
                newHead = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        }
        return newHead;
    }
}
