package LeetCode.tree;

import java.util.*;

public class RearangeRoad {
    public static void main(String[] args) {
        RearangeRoad rearangeRoad = new RearangeRoad();
        System.out.println(rearangeRoad.minReorder(6, new int[][]{{0,1}, {1,3}, {2,3}, {4,0}, {4,5}}));
    }

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, Set<Integer>> input = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, Set<Integer>> undirected = new HashMap<Integer, Set<Integer>>();
        for (int[] connection : connections) {
            input.putIfAbsent(connection[0], new HashSet<>());
            undirected.putIfAbsent(connection[0], new HashSet<>());
            undirected.putIfAbsent(connection[1], new HashSet<>());
            undirected.get(connection[0]).add(connection[1]);
            undirected.get(connection[1]).add(connection[0]);
            input.get(connection[0]).add(connection[1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer v : undirected.get(curr)) {
                if (visited[v]) continue;
                visited[v] = true;
                queue.add(v);
                if (input.containsKey(curr) && input.get(curr).contains(v)) count++;
            }
        }
        return count;
    }
}
