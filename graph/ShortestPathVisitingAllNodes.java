package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {

    public static void main(String[] args) {
        ShortestPathVisitingAllNodes allNodes = new ShortestPathVisitingAllNodes();
        System.out.println(allNodes.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));
    }


    public int shortestPathLength(int[][] graph) {
        //List, 0 - node, 1 - path already, 2, (3,4,5...) - visited
        Queue<Node> q = new ArrayDeque<>();
        Set<String> states = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> toAdd = new HashSet<>();
            toAdd.add(i);
            q.add(new Node(i, 0, toAdd));
            states.add(formString(i, toAdd));
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.visited.size() == graph.length)
                res = Math.min(res, curr.dist);
            for (int next : graph[curr.vertex]) {
                HashSet<Integer> toAdd = new HashSet<>(curr.visited);
                toAdd.add(next);
                if (!states.contains(formString(next, toAdd))) {
                    q.add(new Node(next, curr.dist + 1, toAdd));
                    states.add(formString(next, toAdd));
                }
            }
        }
        return res;
    }

    private String formString(int curr, Set<Integer> state) {
        StringBuilder sb = new StringBuilder();
        sb.append(curr);
        state.stream().sorted().forEach(sb::append);
        return sb.toString();
    }

    private class Node {
        int vertex;
        int dist;
        Set<Integer> visited;

        public Node(int vertex, int dist, Set<Integer> visited) {
            this.vertex = vertex;
            this.dist = dist;
            this.visited = visited;
        }
    }
}
