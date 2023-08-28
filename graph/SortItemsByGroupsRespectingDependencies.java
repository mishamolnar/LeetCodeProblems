package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortItemsByGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> itemsGraph = new HashMap<>();
        Map<Integer, List<Integer>> groupsGraph = new HashMap<>();
        for (int curr = 0; curr < beforeItems.size(); curr++) {
            for (Integer before : beforeItems.get(curr)) {
                if (group[before] == group[curr] && group[curr] != -1) {
                    itemsGraph.putIfAbsent(curr, new ArrayList<>());
                    itemsGraph.get(curr).add(before);
                } else {
                    int currGroup = group[curr] == -1 ? -curr - 1 : group[curr];
                    int beforeGroup = group[before] == -1 ? -before - 1 : group[before];
                    groupsGraph.putIfAbsent(currGroup, new ArrayList<>());
                    groupsGraph.get(currGroup).add(beforeGroup);
                }
            }
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> stack = new HashMap<>();
        List<Integer> groupRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!topologicalSort(group[i] == - 1 ? (-i - 1) : group[i], groupsGraph, visited, stack, groupRes)) {
                return new int[0];
            }
        }
        Map<Integer, List<Integer>> groupToItem = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] != -1) {
                groupToItem.putIfAbsent(group[i], new ArrayList<>());
                groupToItem.get(group[i]).add(i);
            }
        }
        int[] res = new int[n];
        visited.clear();
        stack.clear();
        int iterator = 0;
        for (Integer groupItem: groupRes) {
            if (groupItem < 0) {
                res[iterator++] = -groupItem - 1;
            } else {
                List<Integer> currRes = new ArrayList<>();
                for (Integer singleItem : groupToItem.get(groupItem)) {
                    if (!topologicalSort(singleItem, itemsGraph, visited, stack, currRes))
                        return new int[0];
                }
                visited.clear();
                stack.clear();
                for (Integer currRe : currRes) {
                    res[iterator++] = currRe;
                }
            }
        }
        return res;
    }


    private boolean topologicalSort(int curr, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited, Map<Integer, Boolean> stack, List<Integer> res) {
        if (visited.getOrDefault(curr, false))
            return true;
        visited.put(curr, true);
        stack.put(curr, true);
        for (Integer next : graph.getOrDefault(curr, Collections.emptyList())) {
            if (stack.getOrDefault(next, false))
                return false;
            else if (!visited.getOrDefault(next, false) && !topologicalSort(next, graph, visited, stack, res))
                return false;
        }
        res.add(curr);
        stack.remove(curr);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortItemsByGroupsRespectingDependencies().sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, List.of(List.of(), List.of(6), List.of(5), List.of(6), List.of(3, 6), List.of(), List.of(), List.of()))));
    }
}
