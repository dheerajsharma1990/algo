package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RearrangeListTest {

    public ListNode<Character> rearrange(ListNode<Character> list) {
        if(list == null) {
            return null;
        }
        ListNode<Character> middle = findMiddle(list);
        ListNode<Character> firstList = list;
        ListNode<Character> secondList = middle.getNext();
        middle.setNext(null);
        ListNode<Character> secondReverse = reverse(secondList);
        return mergeAlternate(firstList, secondReverse);
    }

    private ListNode<Character> mergeAlternate(ListNode<Character> firstList, ListNode<Character> secondReverse) {
        if (secondReverse == null) {
            return firstList;
        }
        firstList.setNext(mergeAlternate(secondReverse, firstList.getNext()));
        return firstList;
    }

    private ListNode<Character> reverse(ListNode<Character> list) {
        if (list == null) {
            return null;
        }
        ListNode<Character> prev = null;
        ListNode<Character> curr = list;
        ListNode<Character> next = curr.getNext();
        while (next != null) {
            curr.setNext(prev);
            prev = curr;
            curr = next;
            next = next.getNext();
        }
        curr.setNext(prev);
        return curr;
    }

    private ListNode<Character> findMiddle(ListNode<Character> list) {
        ListNode<Character> head = list;
        ListNode<Character> tail = list;
        while (tail != null && tail.getNext() != null && tail.getNext().getNext() != null) {
            head = head.getNext();
            tail = tail.getNext().getNext();
        }
        return head;
    }

    @Test
    public void shouldReturnNullForNullList() {
        assertThat(rearrange(null), nullValue());
    }

    @Test
    public void shouldArrangeSingleNodeList() {
        assertThat(rearrange(new ListNode<>('g')), is(new ListNode<>('g')));
    }

    @Test
    public void shouldArrangeOddLengthNodeList() {
        assertThat(rearrange(new ListNode<>('g', new ListNode<>('e', new ListNode<>('k')))),
                is(new ListNode<>('g', new ListNode<>('k', new ListNode<>('e')))));
    }

    @Test
    public void shouldArrangeEvenLengthNodeList() {
        assertThat(rearrange(new ListNode<>('g', new ListNode<>('e', new ListNode<>('e', new ListNode<>('k'))))),
                is(new ListNode<>('g', new ListNode<>('k', new ListNode<>('e', new ListNode<>('e'))))));
    }

}