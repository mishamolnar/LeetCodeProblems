package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleTwoSecondTry {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            G.putIfAbsent(prerequisite[1], new ArrayList<>());
            G.get(prerequisite[1]).add(prerequisite[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(i, deque, G, visiting, visited);
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollLast();
            if (res[i] == -1) return new int[0];
        }
        return res;
    }

    private void dfs(int v, Deque<Integer> deque, Map<Integer, List<Integer>> G, boolean[] visited, boolean[] visiting) {
        if (visited[v]) return;
        visited[v] = true;
        visiting[v] = true;
        for (Integer w : G.getOrDefault(v, Collections.emptyList())) {
            if (visiting[w]) {
                deque.addLast(-1);
                return;
            } else if (!visited[w]) {
                dfs(w, deque, G, visited, visiting);
            }
        }
        visiting[v] = false;
        deque.addLast(v);
    }
}
