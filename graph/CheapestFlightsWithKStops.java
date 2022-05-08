package LeetCode.graph;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// not solved https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/
// Time Limit Exceeded error
public class CheapestFlightsWithKStops {

    public static void main(String[] args) {
        CheapestFlightsWithKStops cpf = new CheapestFlightsWithKStops();
        System.out.println(cpf.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Integer>[] adj = new Map[n];
        for(int i = 0; i < n; i++) adj[i] = new HashMap<>();
        for (int[] flight : flights) {
            adj[flight[0]].put(flight[1], flight[2]);
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int[] numberOfStops = new int[n];
        Arrays.fill(numberOfStops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{src, 0, 0}); //dest, price, count

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            if (curr[2] > k) continue;
            for (Integer dist : adj[curr[0]].keySet()) {
                pq.add(new int[]{dist, curr[1] + adj[curr[0]].get(dist), curr[2] + 1});
                if (curr[1] + adj[curr[0]].get(dist) < distances[dist]) {
                    distances[dist] = curr[1] + adj[curr[0]].get(dist);
                } else if (numberOfStops[dist] > curr[2] + 1) {
                    numberOfStops[dist] = curr[2] + 1;
                }
            }
        }
        return distances[dst] < Integer.MAX_VALUE ? distances[dst] : -1;
    }
}
