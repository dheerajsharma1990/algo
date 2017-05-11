package com.algo.tree;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BottomLeftValueTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, TreeNode> leftMostMap = new HashMap<>();
        findBottom(root, 1, leftMostMap);
        int max = leftMostMap.keySet().stream().reduce(Integer::max).get();
        return leftMostMap.get(max).val;
    }

    private void findBottom(TreeNode root, int level, Map<Integer, TreeNode> leftMostMap) {
        if (root != null) {
            if (!leftMostMap.containsKey(level)) {
                leftMostMap.put(level, root);
            }
            findBottom(root.left, level + 1, leftMostMap);
            findBottom(root.right, level + 1, leftMostMap);
        }
    }

    @Test
    public void shouldReturn1ForSingleNodeTree() {
        //given
        TreeNode node = new TreeNode(1);

        //then
        assertThat(findBottomLeftValue(node), is(1));
    }

    @Test
    public void shouldReturnLeftMostNode() {
        //given
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);

        //then
        assertThat(findBottomLeftValue(node), is(4));
    }

}
