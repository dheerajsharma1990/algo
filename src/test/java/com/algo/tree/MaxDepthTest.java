package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxDepthTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        return Math.max(maxDepth(a.left), maxDepth(a.right)) + 1;
    }

    private int findMax(TreeNode a, int[] max) {
        if (a == null) {
            return 0;
        }
        int leftHeight = findMax(a.left, max);
        int rightHeight = findMax(a.right, max);
        max[0] = Math.max((Math.max(leftHeight, rightHeight) + 1), max[0]);
        return leftHeight + rightHeight + 1;
    }

    @Test
    public void shouldReturnInOrderForSingleNodeTree() {
        assertThat(maxDepth(new TreeNode(1)), is(1));
    }

    @Test
    public void shouldReturnInOrderForAnyNodesTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        assertThat(maxDepth(root), is(4));
    }

}