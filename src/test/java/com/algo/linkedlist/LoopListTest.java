package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoopListTest {

    private final LoopList loopList = new LoopList();

    @Test
    public void shouldReturnFalseForNotCircularSingleNode() {
        //given
        ListNode<Integer> head = new ListNode<>(1);

        //when
        ListNode loopNode = loopList.getLoopNode(head);

        //then
        assertThat(loopNode, nullValue());
    }

    @Test
    public void shouldReturnFalseForNonCircularMultiNode() {
        //given
        ListNode<Integer> head = new ListNode<>(1);
        head.setNext(new ListNode<Integer>(2));
        head.getNext().setNext(new ListNode<Integer>(3));

        //when
        ListNode loopNode = loopList.getLoopNode(head);

        //then
        assertThat(loopNode, nullValue());
    }

    @Test
    public void shouldReturnTrueForCircularSingleNode() {
        //given
        ListNode<Integer> head = new ListNode<>(1);
        head.setNext(head);

        //when
        ListNode<Integer> loopNode = loopList.getLoopNode(head);

        //then
        assertThat(loopNode, is(head));
    }

    @Test
    public void shouldReturnTrueForCircularMultiNode() {
        //given
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        head.setNext(second);
        head.getNext().setNext(third);
        head.getNext().getNext().setNext(second);

        //when
        ListNode<Integer> loopNode = loopList.getLoopNode(head);

        //then
        assertThat(loopNode, is(second));
    }

}
