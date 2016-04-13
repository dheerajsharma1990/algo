package com.algo.tree;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KthSmallestBSTTest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            k--;
            if (k == 0) {
                return treeNode.val;
            }
            root = treeNode.right;
        }
    }

    @Test
    public void shouldReturnKthSmallestElement() {
        //given
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        //then
        assertThat(kthSmallest(root1, 1), is(1));
        assertThat(kthSmallest(root1, 2), is(2));
        assertThat(kthSmallest(root1, 3), is(3));


        //given
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.right = new TreeNode(4);

        //then
        assertThat(kthSmallest(root2, 1), is(1));
        assertThat(kthSmallest(root2, 2), is(2));
        assertThat(kthSmallest(root2, 3), is(3));
        assertThat(kthSmallest(root2, 4), is(4));
    }
}
