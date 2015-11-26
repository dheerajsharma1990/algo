package com.algo.tree;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartesianTreeTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(List<Integer> a) {
        return buildTree(a, 0, a.size() - 1);
    }

    private TreeNode buildTree(List<Integer> a, int i, int j) {
        if (i == j) {
            return new TreeNode(a.get(i));
        }
        if (i > j) {
            return null;
        }

        int max = findMaxIndex(a, i, j);
        TreeNode node = new TreeNode(a.get(max));
        node.left = buildTree(a, i, max - 1);
        node.right = buildTree(a, max + 1, j);
        return node;
    }

    private int findMaxIndex(List<Integer> a, int i, int j) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int k = i; k <= j; k++) {
            if (max < a.get(k)) {
                max = a.get(k);
                index = k;
            }
        }
        return index;
    }

    @Test
    public void shouldBuildTreeForSingleElement() {
        assertThat(buildTree(Arrays.asList(1)).val, is(1));
    }

    @Test
    public void shouldBuildTreeNullForEmptyList() {
        assertThat(buildTree(Collections.<Integer>emptyList()), nullValue());
    }

    @Test
    public void shouldBuildTreeSkewedTree() {
        assertThat(buildTree(Arrays.asList(1, 2, 3)).val, is(3));
        assertThat(buildTree(Arrays.asList(1, 2, 3)).left.val, is(2));
        assertThat(buildTree(Arrays.asList(1, 2, 3)).left.left.val, is(1));
    }

    @Test
    public void shouldBuildTreeForRandomArray() {
        assertThat(buildTree(Arrays.asList(3, 4, 1, 5)).val, is(5));
        assertThat(buildTree(Arrays.asList(3, 4, 1, 5)).left.val, is(4));
        assertThat(buildTree(Arrays.asList(3, 4, 1, 5)).left.left.val, is(3));
        assertThat(buildTree(Arrays.asList(3, 4, 1, 5)).left.right.val, is(1));
    }

}
