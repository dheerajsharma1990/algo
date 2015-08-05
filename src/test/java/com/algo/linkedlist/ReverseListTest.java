package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseListTest {

    private final ReverseList reverseList = new ReverseList();

    @Test
    public void shouldReverseOneNodeList() {
        //given
        ListNode<Integer> head = new ListNode(1);

        //when
        ListNode<Integer> reverse = reverseList.reverse(head);

        //then
        assertThat(reverse, notNullValue());
        assertThat(reverse.getItem(), is(1));
        assertThat(reverse.getNext(), nullValue());

    }

    @Test
    public void shouldReverseMoreThenOneNodeList() {
        //given
        ListNode<Integer> head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));

        //when
        ListNode<Integer> reverse = reverseList.reverse(head);

        //then
        assertThat(reverse, notNullValue());
        assertThat(reverse.getItem(), is(3));
        assertThat(reverse.getNext().getItem(), is(2));
        assertThat(reverse.getNext().getNext().getItem(), is(1));
        assertThat(reverse.getNext().getNext().getNext(), nullValue());

    }
}