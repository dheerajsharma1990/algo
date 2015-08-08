package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class DeleteNodeTest {

    private DeleteNode deleteNode = new DeleteNode();

    @Test
    public void shouldNotDeleteSingleElementNode() {

        //given
        ListNode<Integer> list = new ListNode<>(1, null);

        //when
        deleteNode.deleteNode(list);

        //then
        assertThat(list, notNullValue());
        assertThat(list.getItem(), is(1));
    }

    @Test
    public void shouldNotDeleteTailElement() {
        //given
        ListNode<Integer> listNode = new ListNode<>(2, null);
        ListNode<Integer> list = new ListNode<>(1, listNode);

        //when
        deleteNode.deleteNode(listNode);

        //then
        assertThat(list, notNullValue());
        assertThat(list.getItem(), is(1));
        assertThat(list.getNext(), notNullValue());
        assertThat(list.getNext().getItem(), is(2));
    }

    @Test
    public void shouldDeleteElement() {
        //given
        ListNode<Integer> listNode = new ListNode<>(2, null);
        ListNode<Integer> list = new ListNode<>(1, listNode);

        //when
        deleteNode.deleteNode(list);

        //then
        assertThat(list, notNullValue());
        assertThat(list.getItem(), is(2));
        assertThat(list.getNext(), nullValue());
    }

    @Test
    public void shouldDeleteMiddleElement() {
        //given
        ListNode<Integer> listNode3 = new ListNode<>(3, null);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(1, listNode2);

        //when
        deleteNode.deleteNode(listNode2);

        //then
        assertThat(listNode1, notNullValue());
        assertThat(listNode1.getNext(), notNullValue());
        assertThat(listNode1.getNext().getItem(), is(3));
        assertThat(listNode1.getNext().getNext(), nullValue());
    }

}
