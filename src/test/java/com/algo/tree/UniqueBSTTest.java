package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UniqueBSTTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return createTrees(1, n);
    }

    private List<TreeNode> createTrees(int start, int end) {
        if (start > end) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(null);
            return treeNodes;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int k = start; k <= end; k++) {
            List<TreeNode> left = createTrees(start, k - 1);
            List<TreeNode> right = createTrees(k + 1, end);
            for (TreeNode treeNode : left) {
                TreeNode root = new TreeNode(k);
                root.left = treeNode;
                for (TreeNode t : right) {
                    root.right = t;
                    ans.add(clone(root));
                }
            }
        }
        return ans;
    }

    private TreeNode clone(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode x = new TreeNode(root.val);
        x.left = clone(root.left);
        x.right = clone(root.right);
        return x;
    }

    @Test
    public void shouldGenerateUniqueBSTFor2() {
        //when
        List<TreeNode> trees = generateTrees(2);

        //then
        assertThat(trees.size(), is(2));
    }

    @Test
    public void shouldGenerateUniqueBSTFor3() {
        //when
        List<TreeNode> trees = generateTrees(3);

        //then
        assertThat(trees.size(), is(5));
    }

    @Test
    public void shouldGenerateUniqueBSTFor1() {
        //when
        List<TreeNode> trees = generateTrees(1);

        //then
        assertThat(trees.size(), is(1));
    }

    @Test
    public void shouldGenerateUniqueBSTFor4() {
        //when
        List<TreeNode> trees = generateTrees(4);

        //then
        assertThat(trees.size(), is(1));
    }

}
