package LeetCode.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//link -https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer>[] adj = new Map[n];
        for (int[] time : times) { // формуємо adj list
            if (adj[time[0] - 1] == null) adj[time[0] - 1] = new HashMap<>();
            adj[time[0] - 1].put(time[1] - 1, time[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // pq де елементи розташовуються за найменшим часом

        pq.add(new int[]{0, k - 1});

        boolean[] visited = new boolean[n];
        int res = 0;

        while (!pq.isEmpty()) { //Dijkstra algo
            int[] curr = pq.remove();
            int node = curr[1];
            int time = curr[0];
            if (visited[node]) continue;
            visited[node] = true;
            res = time; // кожна ітерація це остання з оглянутих нами нода - тому кожен раз обновляємо результат
            n--;
            if (adj[node] != null) {
                for (Integer next : adj[node].keySet()) {
                    pq.add(new int[]{time + adj[node].get(next), next});
                }
            }
        }

        return n == 0 ? res : -1;
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }
}
