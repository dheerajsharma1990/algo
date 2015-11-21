package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CycleListTest {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode a) {
        ListNode first = a;
        ListNode second = a;
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                break;
            }
        }

        if (second == null || second.next == null) {
            return null;
        }
        first = a;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    @Test
    public void shouldDetectCycles() {
        ListNode list = getList(1, 2, 3, 4);
        addCycle(list, 3);
        assertThat(detectCycle(list).val, is(3));
    }

    @Test
    public void shouldDetectCyclesLongList() {
        ListNode list = getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        addCycle(list, 7);
        assertThat(detectCycle(list).val, is(7));
    }

    @Test
    public void shouldDetectNoCycles() {
        ListNode list = getList(1, 2, 3, 4);
        assertThat(detectCycle(list), nullValue());
    }

    @Test
    public void shouldDetectNoCycles1() {
        ListNode list = getList(87797,23219,41441,58396,48953,94603,2721,95832,49029,98448,65450 );
        assertThat(detectCycle(list), nullValue());
    }

    @Test
    public void shouldDetectCyclesSingleNode() {
        ListNode list = getList(1);
        list.next = list;
        assertThat(detectCycle(list).val, is(1));
    }

    private void addCycle(ListNode listNode, int point) {
        ListNode x = listNode;
        while (x.next != null) {
            x = x.next;
        }
        for (int i = 1; i < point; i++) {
            listNode = listNode.next;
        }
        x.next = listNode;
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

}
