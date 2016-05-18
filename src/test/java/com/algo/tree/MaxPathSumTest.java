package com.algo.tree;

public class MaxPathSumTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode a) {
        int max[] = new int[0];
        max[0] = Integer.MIN_VALUE;
        calculate(a, max);
        return max[0];
    }

    private int calculate(TreeNode a, int[] max) {
        if (a == null) {
            return 0;
        }
        int left = calculate(a.left, max);
        int right = calculate(a.right, max);
        int firstMax = Math.max(left + a.val, a.val);
        int secondMax = Math.max(firstMax + right, firstMax);
        max[0] = Math.max(max[0], secondMax);
        return Math.max(Math.max(left, right) + a.val, a.val);
    }
}
