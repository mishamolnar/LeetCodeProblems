package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] points = new int[n];
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        calcRoot(0, graph, points, distances, visited);
        Arrays.fill(visited, false);
        visited[0] = true;
        for (Integer child : graph.getOrDefault(0, Collections.emptyList())) {
            calculateNodes(child, distances[0], n, distances, graph, points, visited);
        }
        return distances;
    }

    private void calcRoot(int curr, Map<Integer, List<Integer>> graph, int[] points, int[] distances, boolean[] visited) {
        if (visited[curr]) return;
        visited[curr] = true;
        int children = 1;
        int dist = 0;
        for (Integer next : graph.getOrDefault(curr, Collections.emptyList())) {
            calcRoot(next, graph, points, distances, visited);
            children += points[next];
            dist += (distances[next] + points[next]);
        }
        points[curr] = children;
        distances[curr] = dist;
    }

    private void calculateNodes(int curr, int parentScore, int n, int[] res, Map<Integer, List<Integer>> graph, int[] children, boolean[] visited) {
        if (visited[curr]) return;
        visited[curr] = true;
        int notChildren = n - children[curr];
        res[curr] = parentScore - children[curr] + notChildren;
        for (Integer next : graph.getOrDefault(curr, Collections.emptyList())) {
            calculateNodes(next, res[curr], n, res, graph, children, visited);
        }
    }
}
