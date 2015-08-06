package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PalindromeListTest {

    private final PalindromeList palindromeList = new PalindromeList(new ReverseList());

    @Test
    public void emptyListIsPalindrome() {
        assertThat(palindromeList.isPalindrome(null), is(true));
    }

    @Test
    public void singleNodeListIsPalindrome() {
        assertThat(palindromeList.isPalindrome(new ListNode(2)), is(true));
    }

    @Test
    public void List12IsNotPalindrome() {
        assertThat(palindromeList.isPalindrome(new ListNode(1, new ListNode(2))), is(false));
    }

    @Test
    public void List121IsPalindrome() {
        assertThat(palindromeList.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))), is(true));
    }
}
