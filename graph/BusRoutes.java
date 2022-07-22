package LeetCode.graph;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/bus-routes/submissions/
public class BusRoutes {


    //O(N^2) where n is number of busses
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        List<Set<Integer>> list = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int[] route : routes) {
            list.add(Arrays.stream(route).boxed().collect(Collectors.toSet()));
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).stream().anyMatch(list.get(j)::contains)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(source)) queue.add(i);
            if (list.get(i).contains(target)) targets.add(i);
        }
        int steps = 1;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int v = queue.poll();
                if (visited.contains(v)) continue;
                if (targets.contains(v)) return steps;
                visited.add(v);
                queue.addAll(graph.get(v));
            }
            steps++;
        }
        return -1;
    }

    //TLE
    public int numBusesToDestinationByBusStops(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] route : routes) {
            for (int i : route) {
                map.putIfAbsent(i, new ArrayList<>());
                map.get(i).add(route);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>(map
                .get(source)
                .stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList()));
        int steps = 1;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int j = queue.poll();
                if (visited.contains(j)) continue;
                if (j == target) return steps;
                visited.add(j);
                queue.addAll(map.get(j)
                        .stream()
                        .flatMapToInt(Arrays::stream)
                        .boxed()
                        .collect(Collectors.toList()));
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();
        System.out.println(busRoutes.numBusesToDestination(new int[][]{{1,2,7}, {3,6,7}}, 1, 6));
    }
}
