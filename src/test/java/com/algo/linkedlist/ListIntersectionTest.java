package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListIntersectionTest {

    private final ListIntersection listIntersection = new ListIntersection();

    @Test
    public void shouldReturnNullIfAnyListIsNull() {
        //when
        ListNode common = listIntersection.getIntersectionNode(new ListNode(1, null), null);
        ListNode common1 = listIntersection.getIntersectionNode(null, new ListNode(1, null));

        //then
        assertThat(common, nullValue());
        assertThat(common1, nullValue());
    }

    @Test
    public void shouldReturnNullIfListAreIndependent() {
        //when
        ListNode common = listIntersection.getIntersectionNode(new ListNode(1, null), new ListNode(2, null));

        //then
        assertThat(common, nullValue());
    }

    @Test
    public void shouldReturnFirstNodeForSameList() {
        //given
        ListNode listNode = new ListNode(1, null);

        //when
        ListNode common = listIntersection.getIntersectionNode(listNode, listNode);

        //then
        assertThat(common, is(listNode));
    }

    @Test
    public void shouldReturnCommonNodeForSameList() {
        //given
        ListNode listNode = new ListNode(1, null);

        ListNode firstList = new ListNode(3, new ListNode(2, listNode));
        ListNode secondList = new ListNode(4, new ListNode(3, new ListNode(2, listNode)));

        ListNode common = listIntersection.getIntersectionNode(firstList, secondList);

        //then
        assertThat(common, is(listNode));
    }
}