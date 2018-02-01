package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubsetTreeEqualTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t) || (s.left != null && isSubtree(s.left, t)) || (s.right != null && isSubtree(s.right, t));
    }

    private boolean isSameTree(TreeNode x, TreeNode t) {
        return (x == null && t == null) || ((x != null && t != null) && x.val == t.val && isSameTree(x.left, t.left) && isSameTree(x.right, t.right));
    }


    @Test
    public void shouldReturnTrueForSubTree() {
        //given
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.left.left = new TreeNode(3);
        s.left.right = new TreeNode(4);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(3);
        t.right = new TreeNode(4);


        //then
        assertThat(isSubtree(s, t), is(true));
    }

    @Test
    public void shouldReturnTrueForNullTrees() {
        //then
        assertThat(isSubtree(null, null), is(true));
    }

    @Test
    public void shouldReturnFalseForNonSubTrees() {
        //given
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.left.left = new TreeNode(3);
        s.left.right = new TreeNode(4);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(3);


        //then
        assertThat(isSubtree(s, t), is(false));
    }

    @Test
    public void shouldReturnTrueForSkewedTrees() {
        //given
        TreeNode s = new TreeNode(1);
        s.right = new TreeNode(2);
        s.right.right = new TreeNode(3);
        s.right.right.left = new TreeNode(4);
        s.right.right.right = new TreeNode(5);

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);


        //then
        assertThat(isSubtree(s, t), is(true));
    }

}
