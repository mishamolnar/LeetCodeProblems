package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumEmployeesToBeInvitedToAMeeting {
    public int maximumInvitations(int[] favorite) {
        //create graph -> vertex, who this vertex can bring. that means arr[i] transforms map.get(arr[i]).add(i)
        //find biggest circle from this graph
        //then find the biggest cycle in the graph
        //find cycles length of 2
        //then find the longest chain from them
        List<Integer>[] graph = new List[favorite.length];//creating graph
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++)
            graph[favorite[i]].add(i);

        boolean[] used = new boolean[favorite.length];
        int[] path = new int[favorite.length];
        Arrays.fill(path, -1);
        int res = 0;
        for (int i = 0; i < favorite.length; i++) {
            res = Math.max(res, longestCycle(i, 0, favorite, path, used));
        }

        List<int[]> doubleCycles = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++) {
            if (i == favorite[favorite[i]] && i < favorite[i])
                doubleCycles.add(new int[]{i, favorite[i]});
        }

        int acyclicRes = 0;
        for (int[] doubleCycle : doubleCycles) {
            acyclicRes += Math.max(res, longestAcyclicPath(doubleCycle[0], doubleCycle[1], graph) + longestAcyclicPath(doubleCycle[1], doubleCycle[0], graph));
        }
        return Math.max(acyclicRes, res);
    }

    private int longestAcyclicPath(int curr, int prev, List<Integer>[] graph) {
        int res = 0;
        for (Integer next : graph[curr]) {
            if (prev != next)
                res = Math.max(res, longestAcyclicPath(next, curr, graph));
        }
        return res + 1;
    }

    private int longestCycle(int curr, int length, int[] favorites, int[] path, boolean[] used) {
        if (used[curr])
            return -1;
        if (path[curr] != -1)
            return length - path[curr];
        path[curr] = length;
        int res = longestCycle(favorites[curr], length + 1, favorites, path, used);
        used[curr] = true;
        return res;
    }
}
