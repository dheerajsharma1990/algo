package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HouseRobberIIITest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int arr[] = new int[1];
        return max(root, arr);
    }

    private int max(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        int arr1[] = new int[1];
        int arr2[] = new int[1];
        int left = max(root.left, arr1);
        int right = max(root.right, arr2);
        int max = Math.max(root.val + arr1[0] + arr2[0], left + right);
        arr[0] = left + right;
        return max;
    }

    @Test
    public void shouldReturnMaxForSingleNodeTree() {
        //given
        TreeNode root = new TreeNode(1);

        //then
        assertThat(rob(root), is(1));
    }

    @Test
    public void shouldReturnMaxForTwoNodeTree() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        //then
        assertThat(rob(root), is(2));
    }

    @Test
    public void shouldReturnMaxForThreeNodeCompleteTree() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        //then
        assertThat(rob(root), is(5));
    }

    @Test
    public void shouldReturnMaxForFourNodeCompleteTreeMaxRoot() {
        //given
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);

        //then
        assertThat(rob(root), is(16));
    }

    @Test
    public void shouldReturnMaxForOtherTypeOfTreePart1() {
        //given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        //then
        assertThat(rob(root), is(7));
    }

    @Test
    public void shouldReturnMaxForOtherTypeOfTreePart2() {
        //given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        //then
        assertThat(rob(root), is(9));
    }

}
