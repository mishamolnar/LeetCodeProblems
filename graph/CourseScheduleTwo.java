package LeetCode.graph;

import java.util.*;

public class CourseScheduleTwo {
    private boolean[] isMarked;
    private boolean[] onStack;
    private boolean hasCycle;

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer>[] vertices = new LinkedList[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            vertices[i] = new LinkedList<>();
//        }
//        for (int[] pre : prerequisites) {
//            vertices[pre[1]].add(pre[0]);
//        }
//        isMarked = new boolean[numCourses];
//        onStack = new boolean[numCourses];
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            dfs(vertices, queue, i);
//            if (hasCycle) return new int[]{};
//        }
//        int[] result = new int[numCourses];
//        for (int i = numCourses - 1; i  >= 0; i--) {
//            result[i] = queue.poll();
//        }
//
//        return result;
//    }
//
//    private void dfs(List<Integer>[] G, Queue<Integer> queue, int V) {
//        isMarked[V] = true;
//        onStack[V] = true;
//        for (Integer w : G[V]) {
//            if (hasCycle) return;
//            if (!isMarked[w]) {
//                dfs(G, queue, w);
//            }
//            if (onStack[w]) {
//                hasCycle = true;
//                return;
//            }
//        }
//        G[V] = new LinkedList<>();
//        onStack[V] = false;
//        if (queue.contains(V)) return; // not optimal, needed for input 3, new int[][]{{1, 0}}
//        queue.add(V);
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (!dfs(i, queue, graph, visited, recStack)) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            result[i] = queue.poll();
        }
        return result;
    }

    // return true if no cycles.
    private boolean dfs(int current, Queue<Integer> queue, List<Integer>[] graph, boolean[] visited, boolean[] recStack) {
        if (visited[current]) {
            return true;
        }

        visited[current] = true;
        recStack[current] = true;

        List<Integer> adjacentNodes = graph[current];
        for (int n : adjacentNodes) {
            // return false if cycle detected.
            if (!visited[n] && !dfs(n, queue, graph, visited, recStack)) return false;
            else if (recStack[n]) return false;
        }

        queue.add(current); // Postorder traversal
        recStack[current] = false;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleTwo courseSchedule = new CourseScheduleTwo();
        System.out.println(Arrays.toString(courseSchedule.findOrder(3, new int[][]{{1, 0}})));
    }

}
