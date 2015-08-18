package com.algo.linkedlist;

public class ListIntersection {

    public ListNode getIntersectionNode(ListNode firstList, ListNode secondList) {
        if (firstList != null && secondList != null) {
            int len1 = getLength(firstList);
            int len2 = getLength(secondList);
            if (len1 > len2) {
                firstList = getHeadAtPosition(firstList, len1 - len2);
            } else {
                secondList = getHeadAtPosition(secondList, len2 - len1);
            }
            return getCommonNode(firstList, secondList);
        }
        return null;
    }

    private ListNode getCommonNode(ListNode first, ListNode second) {
        if (first == second) {
            return first;
        }
        return getCommonNode(first.getNext(), second.getNext());
    }

    private ListNode getHeadAtPosition(ListNode head, int i) {
        if (i == 0) {
            return head;
        }
        return getHeadAtPosition(head.getNext(), i - 1);
    }

    private int getLength(ListNode list) {
        if (list == null) {
            return 0;
        }
        return 1 + getLength(list.getNext());
    }
}
