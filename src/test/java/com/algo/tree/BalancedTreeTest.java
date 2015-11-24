package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BalancedTreeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int isBalanced(TreeNode a) {
        return balanced(a, new int[1]) ? 1 : 0;
    }

    private boolean balanced(TreeNode a, int[] height) {
        if (a == null) {
            height[0] = 0;
            return true;
        }

        int leftHeight[] = new int[1];
        int rightHeight[] = new int[1];
        boolean leftBalanced = balanced(a.left, leftHeight);
        boolean rightBalanced = balanced(a.right, rightHeight);
        height[0] = 1 + Math.max(leftHeight[0], rightHeight[0]);
        return leftBalanced && rightBalanced && Math.abs(leftHeight[0] - rightHeight[0]) < 2;
    }

    @Test
    public void shouldReturn1ForSingleNodeTree() {
        //given
        TreeNode node = new TreeNode(1);

        //then
        assertThat(isBalanced(node), is(1));
    }

    @Test
    public void shouldReturn1ForPerfectTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        //then
        assertThat(isBalanced(node), is(1));
    }

    @Test
    public void shouldReturn1ForTwoNodeTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);

        //then
        assertThat(isBalanced(node), is(1));
    }

    @Test
    public void shouldReturn0ForSkewed3NodeTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);

        //then
        assertThat(isBalanced(node), is(0));
    }

    @Test
    public void shouldReturn0ForNotHeightBalancedTree() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(5);

        //then
        assertThat(isBalanced(node), is(0));
    }

}
