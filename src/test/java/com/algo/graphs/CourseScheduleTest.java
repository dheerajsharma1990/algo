package com.algo.graphs;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CourseScheduleTest {

    class Node {
        int courseId;
        Set<Node> prerequisites = new HashSet<>();
        Set<Node> dependers = new HashSet<>();

        public Node(int courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return courseId == node.courseId;

        }

        @Override
        public int hashCode() {
            return courseId;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            if (!graph.containsKey(courseId)) {
                graph.put(courseId, new Node(courseId));
            }
            if (!graph.containsKey(prerequisite)) {
                graph.put(prerequisite, new Node(prerequisite));
            }
            graph.get(prerequisite).prerequisites.add(graph.get(courseId));
            graph.get(courseId).dependers.add(graph.get(prerequisite));
        }
        Queue<Node> queue = new ArrayDeque<>();
        for (Node node : graph.values()) {
            if (node.prerequisites.isEmpty()) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node depender : node.dependers) {
                depender.prerequisites.remove(node);
                if (depender.prerequisites.isEmpty()) {
                    queue.add(depender);
                }
            }
        }
        for (Node node : graph.values()) {
            if (!node.prerequisites.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(canFinish(1, new int[][]{}), is(true));
        assertThat(canFinish(1, new int[][]{{1, 1}}), is(false));
        assertThat(canFinish(2, new int[][]{}), is(true));
        assertThat(canFinish(2, new int[][]{{2, 1}}), is(true));
        assertThat(canFinish(3, new int[][]{{2, 1}, {3, 1}}), is(true));
        assertThat(canFinish(8, new int[][]{{2, 1}, {4, 1}, {6, 4},
                {3, 2}, {5, 2}, {7, 6}, {8, 7}, {6, 8}}), is(false));
    }
}
