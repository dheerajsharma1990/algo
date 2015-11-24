package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InvertTreeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        return root;
    }


    @Test
    public void shouldInvertSingleNodeTree() {
        //given
        TreeNode node = new TreeNode(1);

        //when
        TreeNode invert = invertTree(node);

        //then
        assertThat(invert.left, nullValue());
        assertThat(invert.right, nullValue());
        assertThat(invert.val, is(1));
    }

    @Test
    public void shouldInvertSkewedTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);

        //when
        TreeNode invert = invertTree(node);

        //then
        assertThat(invert.left, nullValue());
        assertThat(invert.right.val, is(2));
        assertThat(invert.right.right.val, is(3));
        assertThat(invert.val, is(1));
    }

    @Test
    public void shouldInvertPerfectTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        //when
        TreeNode invert = invertTree(node);

        //then
        assertThat(invert.right.val, is(2));
        assertThat(invert.left.val, is(3));
        assertThat(invert.val, is(1));
    }

}
