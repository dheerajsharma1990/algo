package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NodesInCompleteTreeTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int leftHeight = getLeftTreeHeight(root);
        int rightHeight = getRightTreeHeight(root);
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight + 1)) - 1;
        }
        int n = (int) Math.pow(2, leftHeight);
        int start = 1;
        int end = n;
        while (start < (end - 1)) {
            int mid = start + (end - start) / 2;
            TreeNode t = binarySearch(root, 1, n, mid);
            if (t != null) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        TreeNode t1 = binarySearch(root, 1, n, start);
        TreeNode t2 = binarySearch(root, 1, n, end);
        return (((int) Math.pow(2, leftHeight)) - 1) + ((t2 == null) ? t1 == null ? start - 1 : start : end);
    }

    private TreeNode binarySearch(TreeNode root, int start, int end, int num) {
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        if (num <= mid) {
            return binarySearch(root.left, start, mid, num);
        } else {
            return binarySearch(root.right, mid + 1, end, num);
        }

    }

    private int getLeftTreeHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + getLeftTreeHeight(root.left);
    }

    private int getRightTreeHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + getRightTreeHeight(root.right);
    }

    @Test
    public void shouldGetNodesCount() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        assertThat(countNodes(node), is(6));
    }
}
