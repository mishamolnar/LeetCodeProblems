package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] states = new int[graph.length];//0 - not visited, 1 - circle, 2 - visited

        for (int i = 0; i < states.length; i++) {
            if (states[i] == 0)
                dfs(graph, states, i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < states.length; i++) {
            if (states[i] == 2)
                list.add(i);
        }
        return list;
    }

    private boolean dfs(int[][] graph, int[] states, int curr) { //has circle - true, no circle - false
        if (states[curr] != 0)
            return states[curr] == 1;

        states[curr] = 1;

        boolean res = false;
        for (int next : graph[curr]) {
            if (dfs(graph, states, next))
                res = true;
        }
        if (!res) states[curr] = 2;

        return states[curr] == 1;
    }

    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        System.out.println(findEventualSafeStates.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }
}
