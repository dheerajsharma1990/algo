package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SymmetryTreeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int isSymmetric(TreeNode a) {
        return a == null || areEqual(a.left, a.right) ? 1 : 0;
    }

    private boolean areEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else {
            return left.val == right.val && areEqual(left.left, right.right) && areEqual(left.right, right.left);
        }
    }

    @Test
    public void shouldReturnTrueForEmptyTree() {
        assertThat(isSymmetric(null), is(1));
    }

    @Test
    public void shouldReturnTrueForSingleNodeTree() {
        assertThat(isSymmetric(new TreeNode(3)), is(1));
    }

    @Test
    public void shouldReturnTrueForMirrorNodeTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        assertThat(isSymmetric(root), is(1));
    }

    @Test
    public void shouldReturnFalseForNonMirrorNodeTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        assertThat(isSymmetric(root), is(0));
    }
}
