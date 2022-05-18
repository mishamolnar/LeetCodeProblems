package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        System.out.println(allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> temp, int curr) {
        if (curr == graph.length - 1) {
            temp.add(curr);
            result.add(temp);
        } else {
            temp.add(curr);
            for (int i = 0; i < graph[curr].length; i++) {
                dfs(graph, result, new ArrayList<>(temp), graph[curr][i]);
            }
        }
    }
}
