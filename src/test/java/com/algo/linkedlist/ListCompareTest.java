package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListCompareTest {

    public int compareString(ListNode<Character> firstList, ListNode<Character> secondList) {
        if (firstList == null && secondList == null) {
            return 0;
        } else if (firstList != null && secondList != null && firstList.getItem() != secondList.getItem()) {
            return firstList.getItem() > secondList.getItem() ? 1 : -1;
        } else if (secondList == null) {
            return 1;
        } else if (firstList == null) {
            return -1;
        } else {
            return compareString(firstList.getNext(), secondList.getNext());
        }
    }

    @Test
    public void shouldReturn0ForAllNull() {
        assertThat(compareString(null, null), is(0));
    }

    @Test
    public void shouldReturn1ForSmallSecondList() {
        assertThat(compareString(new ListNode<>('g', new ListNode<>('e')), new ListNode<>('g')), is(1));
    }

    @Test
    public void shouldReturnMinus1ForFirstSecondList() {
        assertThat(compareString(new ListNode<>('g'), new ListNode<>('g', new ListNode<>('e'))), is(-1));
    }

    @Test
    public void shouldReturn0ForEqualList() {
        assertThat(compareString(new ListNode<>('g', new ListNode<>('e')), new ListNode<>('g', new ListNode<>('e'))), is(0));
    }

}