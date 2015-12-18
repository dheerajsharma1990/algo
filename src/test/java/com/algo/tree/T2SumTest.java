package com.algo.tree;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class T2SumTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int t2Sum(TreeNode a, int B) {
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        TreeNode x = a;
        TreeNode y = a;
        boolean shouldLeftRun = true;
        boolean shouldRightRun = true;
        while (true) {
            while (x != null && shouldLeftRun) {
                first.push(x);
                x = x.left;
            }
            while (y != null && shouldRightRun) {
                second.push(y);
                y = y.right;
            }

            if (first.empty() && second.empty()) {
                return 0;
            }

            x = shouldLeftRun ? first.pop() : x;
            y = shouldRightRun ? second.pop() : y;
            if (x.val == y.val) {
                return 0;
            } else if ((x.val + y.val) < B) {
                x = x.right;
                shouldLeftRun = true;
                shouldRightRun = false;
            } else if ((x.val + y.val) > B) {
                y = y.left;
                shouldLeftRun = false;
                shouldRightRun = true;
            } else if ((x.val + y.val) == B) {
                return 1;
            }
        }
    }

    private TreeNode root;

    @BeforeClass
    public void createTree() {
        root = new TreeNode(13);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(16);
    }

    @Test
    public void shouldFindSum() {
        assertThat(t2Sum(root, 4), is(0));
        assertThat(t2Sum(root, 8), is(1));
        assertThat(t2Sum(root, 23), is(1));
        assertThat(t2Sum(root, 13), is(0));
        assertThat(t2Sum(root, 19), is(0));
        assertThat(t2Sum(root, 18), is(1));
    }

    @Test
    public void shouldFindSumForOtherTree() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(19);

        assertThat(t2Sum(root, 17), is(1));
    }
}
