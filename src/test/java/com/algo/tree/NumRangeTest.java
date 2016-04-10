package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumRangeTest {

    class Node {
        Node left;
        Node right;
        Range range;
        int sum;

        public Node(Range range) {
            this.range = range;
        }
    }

    class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public NumRangeTest() {

    }

    private NumRangeTest(int[] nums) {
        root = constructTree(nums, 0, nums.length - 1);
    }

    private Node constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        Range range = new Range(start, end);
        Node node = new Node(range);
        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = constructTree(nums, start, mid);
        node.right = constructTree(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }


    private void update(int i, int val) {
        root.sum = updateValueAndSum(root, i, val);
    }

    private int updateValueAndSum(Node root, int i, int val) {
        if (i < root.range.start || i > root.range.end) {
            return 0;
        }
        int start = root.range.start;
        int end = root.range.end;
        int mid = start + (end - start) / 2;
        if (start == end) {
            root.sum = val;
            return val;
        } else if (i <= mid) {
            int update = updateValueAndSum(root.left, i, val);
            root.sum = update + root.right.sum;
            return root.sum;
        } else {
            int update = updateValueAndSum(root.right, i, val);
            root.sum = update + root.left.sum;
            return root.sum;
        }
    }

    private int sumRange(int i, int j) {
        return sumRangeNode(root, i, j);
    }

    private int sumRangeNode(Node root, int i, int j) {
        int start = root.range.start;
        int end = root.range.end;
        int mid = start + (end - start) / 2;
        if (start == i && end == j) {
            return root.sum;
        } else if (j <= mid) {
            return sumRangeNode(root.left, i, j);
        } else if (i > mid) {
            return sumRangeNode(root.right, i, j);
        } else {
            return sumRangeNode(root.left, i, mid) + sumRangeNode(root.right, mid + 1, j);
        }
    }

    @Test
    public void shouldTestNumRange() {
        //given
        NumRangeTest numRangeTest = new NumRangeTest(new int[]{1, 3, 5});

        //then
        assertThat(numRangeTest.sumRange(0, 2), is(9));
        numRangeTest.update(1, 2);
        assertThat(numRangeTest.sumRange(0, 2), is(8));
    }

    @Test
    public void shouldTestNumRangeOnEmptyArray() {
        //given
        NumRangeTest numRangeTest = new NumRangeTest(new int[]{});

    }

    @Test
    public void shouldTestOnLargeArray() {
        //given
        NumRangeTest numRangeTest = new NumRangeTest(new int[]{4, 3, 1, 9, 4, 6, 2, 0, 3});

        //then
        assertThat(numRangeTest.sumRange(0, 8), is(32));
        numRangeTest.update(7, 2);
        assertThat(numRangeTest.sumRange(0, 8), is(34));
        assertThat(numRangeTest.sumRange(3, 6), is(21));
        assertThat(numRangeTest.sumRange(1, 7), is(27));
    }
}