package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeftLeavesSumTest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sum(root, root.left) + sum(root, root.right);
    }

    private int sum(TreeNode parent, TreeNode child) {
        if (child != null) {
            if (child.left == null && child.right == null && parent.left == child) {
                return child.val;
            }
            return sum(child, child.left) + sum(child, child.right);
        }
        return 0;
    }

    @Test
    public void shouldReturnZeroValueForEmptyTree() {
        //then
        assertThat(sumOfLeftLeaves(null), is(0));
    }

    @Test
    public void shouldReturnZeroValueForSingleNodeTree() {
        //given
        TreeNode root = new TreeNode(1);

        //then
        assertThat(sumOfLeftLeaves(root), is(0));
    }

    @Test
    public void shouldReturnLeftNodeForLeftSkewedTree() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        //then
        assertThat(sumOfLeftLeaves(root), is(3));
    }

    @Test
    public void shouldReturnLeftLeavesSumForArbitaryTree() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);

        //then
        assertThat(sumOfLeftLeaves(root), is(17));
    }

}