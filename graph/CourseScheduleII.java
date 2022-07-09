package LeetCode.graph;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class CourseScheduleII {
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            G.putIfAbsent(prerequisite[1], new HashSet<>());
            G.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(G, i , visited, onStack, queue);
            if (hasCycle) return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) res[i] = queue.poll();
        return res;
    }

    private void dfs(HashMap<Integer, HashSet<Integer>> G, int curr,
                     boolean[] visited, boolean[] onStack, Queue<Integer> res) {
        if (onStack[curr]) {
            hasCycle = true;
            return;
        }
        if (visited[curr]) return;
        onStack[curr] = true;
        visited[curr] = true;

        if (G.containsKey(curr)) {
            for (Integer v : G.get(curr)) {
                dfs(G, v, visited, onStack, res);
            }
        }

        onStack[curr] = false;
        res.add(curr);
    }
}
