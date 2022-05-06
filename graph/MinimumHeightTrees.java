package LeetCode.graph;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/submissions/
public class MinimumHeightTrees {


    //O(n) memory and space
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // будуємо новий граф
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) leaves.add(i); // визначаємо всі листя - де кількість зв'язків - 1
        }

        while (n > 2) {
            n -= leaves.size(); // по суті ми віднімаємо листя поки кількість вузлів не 1 або 2 (3 вже багато)
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                int next = adj.get(leaf).iterator().next(); //наступна нода для листа
                adj.get(next).remove(leaf); // видаляємо лист
                if (adj.get(next).size() == 1) newLeaves.add(next); //визначаємо чи після видалення наступна нода стала листом
            }
            leaves = newLeaves; // перепризначаємо листя
        }

        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        System.out.println(minimumHeightTrees.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
    }
}
