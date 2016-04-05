package com.algo.graphs;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CourseSchedulePart2Test {

    class Node {
        private int course;
        private List<Node> dependents = new ArrayList<>();
        private int count = 0;

        public Node(int course) {
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return course == node.course;

        }

        @Override
        public int hashCode() {
            return course;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            if (!graph.containsKey(first)) {
                graph.put(first, new Node(first));
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new Node(second));
            }
            graph.get(first).count++;
            graph.get(second).dependents.add(graph.get(first));
        }
        Queue<Node> queue = new ArrayDeque<>();
        for (Node node : graph.values()) {
            if (node.count == 0) {
                queue.add(node);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ans.add(node.course);
            integers.add(node.course);
            for (Node dependent : node.dependents) {
                dependent.count--;
                if (dependent.count == 0) {
                    queue.add(dependent);
                }
            }
        }
        for (Node node : graph.values()) {
            if (node.count != 0) {
                return new int[0];
            }
        }
        int[] newAns = new int[numCourses];
        int i;
        for (i = 0; i < ans.size(); i++) {
            newAns[i] = ans.get(i);
        }
        for (int j = 0; j < numCourses; j++) {
            if (!integers.contains(j)) {
                newAns[i++] = j;
                integers.add(j);
            }
        }
        return newAns;
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(findOrder(2, new int[][]{{1, 0}}), is(new int[]{0, 1}));
        assertThat(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}), is(new int[]{0, 1, 2, 3}));
        assertThat(findOrder(2, new int[][]{{1, 0}, {0, 1}}), is(new int[]{}));
        assertThat(findOrder(3, new int[][]{{1, 0}}), is(new int[]{0, 1, 2}));
    }
}
