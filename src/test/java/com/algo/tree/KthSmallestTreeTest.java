package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KthSmallestTreeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthsmallest(TreeNode root, int k) {
        int[] init = new int[2];
        init[0] = k;
        init[1] = 0;
        findKth(root, init, k);
        return init[1];
    }

    private void findKth(TreeNode root, int[] result, int k) {
        if (root == null) {
            return;
        }
        if (result[0] == 0) {
            return;
        }

        findKth(root.left, result, k);
        result[0]--;
        if (result[0] == 0) {
            result[1] = root.val;
            return;
        }
        findKth(root.right, result, k);
    }

    @Test
    public void shouldFindKthSingleNodeTree() {
        //given
        TreeNode node = new TreeNode(1);

        //then
        assertThat(kthsmallest(node, 1), is(1));
    }

    @Test
    public void shouldFindKthSkewedTree() {
        //given
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);

        //then
        assertThat(kthsmallest(node, 1), is(1));
        assertThat(kthsmallest(node, 2), is(2));
        assertThat(kthsmallest(node, 3), is(3));
    }

    @Test
    public void shouldFindKthPerfectTree() {
        //given
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        //then
        assertThat(kthsmallest(node, 1), is(1));
        assertThat(kthsmallest(node, 2), is(2));
        assertThat(kthsmallest(node, 3), is(3));
    }

}
