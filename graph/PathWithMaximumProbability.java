package LeetCode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        prob[start] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0],a[0])); //0 - probability , 1 - element
        pq.add(new double[]{1, start});
        Map<Integer, List<double[]>> G = createGraph(edges, succProb); //0 probability, 1 element
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            if (curr[1] == end)
                return curr[0];
            for (double[] next : G.getOrDefault((int) curr[1], Collections.emptyList())) {
                if (curr[0] * next[0] > prob[(int) next[1]]){
                    pq.add(new double[]{curr[0] * next[0], next[1]});
                    prob[(int) next[1]] = curr[0] * next[0];
                }
            }
        }
        return -1;
    }

    private Map<Integer, List<double[]>> createGraph(int[][] edges, double[] succProb) {
        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            map.get(edges[i][1]).add(new double[]{succProb[i], edges[i][0]});
            map.get(edges[i][0]).add(new double[]{succProb[i], edges[i][1]});
        }
        return map;
    }
}
