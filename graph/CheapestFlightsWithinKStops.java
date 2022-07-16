package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>(); //city -> all cities with price as value
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        int[] prices = new int[n];
        int[] stops = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]); //0 source, 1 stops, 2 total price
        pq.add(new int[]{src, -1, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (!map.containsKey(curr[0]) || curr[1] == k) continue;
            for (Map.Entry<Integer, Integer> nextFlight : map.get(curr[0]).entrySet()) {
                if (curr[1] + 1 < stops[nextFlight.getKey()]
                        || curr[2] + nextFlight.getValue() < prices[nextFlight.getKey()]) {
                    pq.add(new int[]{nextFlight.getKey(), curr[1] + 1, curr[2] + nextFlight.getValue()});
                    stops[nextFlight.getKey()] = Math.min(stops[nextFlight.getKey()], curr[1] + 1);
                    prices[nextFlight.getKey()] = Math.min(prices[nextFlight.getKey()], curr[2] + nextFlight.getValue());
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();
        System.out.println(stops.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,200},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
    }
}
