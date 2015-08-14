package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BSTIteratorTest {

    @Test
    public void shouldReturnNextCorrectlyForSingleNodeTree() {
        //given
        TreeNode root = new TreeNode(1, null, null);

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldReturnNextCorrectlyForTwoNodeTree() {
        //given
        TreeNode root = new TreeNode(2, new TreeNode(1, null, null), null);

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldReturnNextCorrectlyForThreeNodeTree() {
        //given
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(1, null, null), null), null);

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldReturnNextCorrectlyForCompleteLeftTree() {
        //given
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), null);

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldReturnNextCorrectlyForZigZagTree() {
        //given
        TreeNode root = new TreeNode(4, new TreeNode(1, null, new TreeNode(3, new TreeNode(2, null, null), null)), null);

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldReturnNextCorrectlyForCompleteTree() {
        //given
        TreeNode root = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));

        //when
        BSTIterator iterator = new BSTIterator(root);

        //then
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

}