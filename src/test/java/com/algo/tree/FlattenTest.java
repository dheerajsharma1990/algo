package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlattenTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode flatten(TreeNode a) {
        return flatten(a, new TreeNode[1]);
    }

    private TreeNode flatten(TreeNode a, TreeNode[] end) {
        if (a == null) {
            end[0] = null;
            return null;
        }

        TreeNode[] le = new TreeNode[1];
        TreeNode[] re = new TreeNode[1];
        TreeNode left = flatten(a.left, le);
        TreeNode right = flatten(a.right, re);
        end[0] = re[0] != null ? re[0] : le[0] != null ? le[0] : a;
        a.left = null;
        a.right = null;
        if (left != null && right != null) {
            a.right = left;
            le[0].right = right;
        } else if (left != null && right == null) {
            a.right = left;
        } else if (left == null && right != null) {
            a.right = right;
        }
        return a;
    }

    @Test
    public void shouldFlatten() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        assertThat(flatten(root).val, is(3));
    }

    @Test
    public void shouldFlattenSkewed() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        assertThat(flatten(root).val, is(1));
    }
}
