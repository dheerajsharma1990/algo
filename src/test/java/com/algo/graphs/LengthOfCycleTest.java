package com.algo.graphs;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LengthOfCycleTest {

    class Node {
        int num;
        List<Node> paths = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }

        public void addPath(Node node) {
            paths.add(node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return num == node.num;

        }

        @Override
        public int hashCode() {
            return num;
        }
    }

    public int detectCycle(int[] arr) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int source = i;
            int destination = arr[i];
            if (destination != -1) {
                if (!graph.containsKey(destination)) {
                    graph.put(destination, new Node(destination));
                }
                if (!graph.containsKey(source)) {
                    graph.put(source, new Node(source));
                }
                graph.get(source).addPath(graph.get(destination));
            }
        }
        Set<Node> visited = new HashSet<>();
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        for (Node node : graph.values()) {
            if (!visited.contains(node)) {
                Map<Integer, Integer> indices = new HashMap<>();
                Stack<Node> stack = new Stack<>();
                navigate(node, visited, indices, stack, max);
            }
        }
        return max[0];
    }

    private void navigate(Node node, Set<Node> visited, Map<Integer, Integer> indices, Stack<Node> stack, int[] maxValue) {
        if (visited.contains(node)) {
            if (indices.containsKey(node.num)) {
                Node peek = stack.peek();
                maxValue[0] = Math.max(maxValue[0], indices.get(peek.num) - indices.get(node.num) + 1);
            }
            return;
        }
        visited.add(node);
        stack.push(node);
        indices.put(node.num, stack.size() - 1);
        for (Node destination : node.paths) {
            navigate(destination, visited, indices, stack, maxValue);
        }
        indices.remove(node.num);
        stack.pop();
    }

    @Test
    public void shouldReturnMaximumLengthCycle() {
        assertThat(detectCycle(new int[]{1, 0}), is(2));
        assertThat(detectCycle(new int[]{4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21}), is(2));
    }
}
