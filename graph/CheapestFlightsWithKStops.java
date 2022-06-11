package LeetCode.graph;

import com.sun.jdi.ArrayReference;

import java.util.*;

// not solved https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/
// Time Limit Exceeded error
public class CheapestFlightsWithKStops {

    public static void main(String[] args) {
        CheapestFlightsWithKStops cpf = new CheapestFlightsWithKStops();
        System.out.println(cpf.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,200},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
    }


        //O(V^2 log(v)) time complexity, because each node can be added multiple times (V times in worst case)
        //O(V^2) space because of PQ
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] price = new int[n];
            int[] stops = new int[n];
            Arrays.fill(price, Integer.MAX_VALUE);
            Arrays.fill(stops, Integer.MAX_VALUE);
            Map<Integer, List<int[]>>  map = new HashMap<>();
            for (int[] flight : flights) {
                map.putIfAbsent(flight[0], new ArrayList<>());
                map.get(flight[0]).add(new int[] {flight[1], flight[2]});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[]{src, 0, 0}); //node, price, steps
            price[src] = 0;
            stops[src] = 0;
            while (!pq.isEmpty()) {
                int[] info = pq.poll();
                int node = info[0], currStops = info[2], cost = info[1];

                if (dst == node) return cost;

                if (currStops == k + 1) continue;

                if (!map.containsKey(node)) continue;
                for (int[] ints : map.get(node)) {
                    int nextNode = ints[0], nextPrice = ints[1];
                    if (price[nextNode] > cost + nextPrice) {
                        price[nextNode] = cost + nextPrice;
                        stops[nextNode] = currStops + 1;
                        pq.offer(new int[]{nextNode, cost + nextPrice, currStops + 1});
                    } else if (currStops < stops[nextNode]) {
                        pq.offer(new int[]{nextNode, cost + nextPrice, currStops + 1});
                    }
                }
            }
            return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
        }
}
