package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InvertTreeTest {

    private final InvertTree invertTree = new InvertTree();

    @Test
    public void shouldInvertASingleNodeTree() {
        //given
        TreeNode root = new TreeNode(1, null, null);

        //when
        invertTree.invertTree(root);

        //then
        assertThat(root.getLeft(), nullValue());
        assertThat(root.getRight(), nullValue());
        assertThat(root.getValue(), is(1));
    }

    @Test
    public void shouldInvertASkewedTree() {
        //given
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);

        //when
        invertTree.invertTree(root);

        //then
        assertThat(root.getLeft(), nullValue());
        assertThat(root.getRight().getValue(), is(2));
        assertThat(root.getValue(), is(1));
    }

    @Test
    public void shouldInvertACompleteTree() {
        //given
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));

        //when
        invertTree.invertTree(root);

        //then
        assertThat(root.getLeft().getValue(), is(3));
        assertThat(root.getRight().getValue(), is(2));
        assertThat(root.getValue(), is(1));
    }
}