package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaximumPathQualityOfGraph {
    int res = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<int[]>[] neib = new List[values.length];
        for (int i = 0; i < neib.length; i++) 
            neib[i] = new ArrayList<>();
        for (int[] edge : edges) {
            neib[edge[0]].add(new int[]{edge[1], edge[2]});
            neib[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] visited = new int[values.length];
        visited[0]++;
        dfs(0, maxTime, values[0], values, neib, visited);
        return this.res;
    }

    private void dfs(int curr, int time, int quality, int[] value, List<int[]>[] neib, int[] visited) {
        if (curr == 0)
            this.res = Math.max(this.res, quality);
        for (int[] ints : neib[curr]) {
            if (time < ints[1]) continue;
            visited[ints[0]]++;
            dfs(ints[0], time - ints[1], quality + (visited[ints[0]] > 1 ? 0 : value[ints[0]]), value, neib, visited);
            visited[ints[0]]--;
        }
    }

    public static void main(String[] args) {
        MaximumPathQualityOfGraph maximumPathQualityOfGraph = new MaximumPathQualityOfGraph();
        System.out.println(maximumPathQualityOfGraph.maximalPathQuality(new int[]{5,10,15,20}, new int[][]{{0, 1, 10}, {1, 2, 10}, {0, 3, 10}}, 30));
    }
}
