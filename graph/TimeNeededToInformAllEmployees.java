package LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //create graph manager -> subordinates
        //run dfs to che check the slowest time
        List<Integer>[] G = new List[n];
        for (int i = 0; i < G.length; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1)
                G[manager[i]].add(i);
        }
        return dfs(headID, G, informTime);
    }


    private int dfs(int current, List<Integer>[] G, int[] informTime) {
        int res = 0;
        for (Integer subordinate : G[current]) {
            res = Math.max(res, informTime[current] + dfs(subordinate, G, informTime));
        }
        return res;
    }
}
