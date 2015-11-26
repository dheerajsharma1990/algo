package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class ZigZagTraversalTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode a) {
        List<List<Integer>> ans = new ArrayList<>();
        if (a == null) {
            return ans;
        }
        boolean rightToLeft = false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(a);
        List<Integer> integers = new ArrayList<>();
        while (!stack1.empty()) {
            TreeNode x = stack1.pop();
            integers.add(x.val);
            if (rightToLeft) {
                if (x.right != null) {
                    stack2.push(x.right);
                }
                if (x.left != null) {
                    stack2.push(x.left);
                }
            } else {
                if (x.left != null) {
                    stack2.push(x.left);
                }
                if (x.right != null) {
                    stack2.push(x.right);
                }
            }
            if (stack1.empty()) {
                List<Integer> mid = integers;
                integers = new ArrayList<>();
                ans.add(mid);
                rightToLeft = !rightToLeft;
                Stack<TreeNode> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
            }
        }
        return ans;
    }

    @Test
    public void shouldReturnSingleNodeForZigZagTraversalOf1Node() {
        assertThat(zigzagLevelOrder(new TreeNode(1)).get(0), hasItems(1));
    }

    @Test
    public void shouldReturnEmptyForEmptyTree() {
        assertThat(zigzagLevelOrder(null).isEmpty(), is(true));
    }

    @Test
    public void shouldReturnZigZagOrderForPerfectTree() {
        //given
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        //then
        assertThat(zigzagLevelOrder(treeNode).get(0), hasItems(1));
        assertThat(zigzagLevelOrder(treeNode).get(1).get(0), is(3));
        assertThat(zigzagLevelOrder(treeNode).get(1).get(1), is(2));
    }

    @Test
    public void shouldReturnZigZagOrderForNotSoPerfectTree() {
        //given
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        //then
        assertThat(zigzagLevelOrder(treeNode).get(0), hasItems(3));
        assertThat(zigzagLevelOrder(treeNode).get(1).get(0), is(20));
        assertThat(zigzagLevelOrder(treeNode).get(1).get(1), is(9));
        assertThat(zigzagLevelOrder(treeNode).get(2).get(0), is(15));
        assertThat(zigzagLevelOrder(treeNode).get(2).get(1), is(7));
    }
}
