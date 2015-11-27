package com.algo.tree;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LCATest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean contains(TreeNode a, int val) {
        if (a == null) {
            return false;
        }
        return a.val == val || contains(a.left, val) || contains(a.right, val);
    }

    public int lca(TreeNode a, int val1, int val2) {
        if (contains(a, val1) && contains(a, val2)) {
            return lcaFinder(a, val1, val2);
        }
        return -1;
    }

    private int lcaFinder(TreeNode a, int val1, int val2) {
        if (a == null) {
            return -1;
        }
        if (a.val == val1 || a.val == val2) {
            return a.val;
        }
        int left = lcaFinder(a.left, val1, val2);
        int right = lcaFinder(a.right, val1, val2);
        return left != -1 && right != -1 ? a.val : left == -1 ? right : left;
    }

    private TreeNode root;

    @BeforeClass
    public void createTree() {
        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
    }

    @Test
    public void shouldFindLCA() {
        assertThat(lca(root, 5, 1), is(3));
        assertThat(lca(root, 5, 4), is(5));
        assertThat(lca(root, 7, 8), is(3));
        assertThat(lca(root, 7, 11), is(-1));
    }

}