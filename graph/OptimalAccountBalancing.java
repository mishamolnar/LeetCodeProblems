package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/optimal-account-balancing/
public class OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        int[] loans = new int[map.size()];
        int count = 0;
        for (Integer i : map.values()) {
            loans[count++] = i;
        }

        return backtrack(loans, 0);
    }

    private int backtrack(int[] loans, int index) {
        while (index < loans.length && loans[index] == 0) index++;

        if (index == loans.length) return 0;

        int minMoves = Integer.MAX_VALUE;

        for (int i = index + 1; i < loans.length; i++) {
            if (loans[index] * loans[i] < 0) {
                loans[i] += loans[index];
                minMoves = Math.min(minMoves, 1 + backtrack(loans, index + 1));
                loans[i] -= loans[index];
            }
        }
        return minMoves;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing optimal = new OptimalAccountBalancing();
        System.out.println(optimal.minTransfers(new int[][]{{0,1,10},{2,0,5}}));
    }
}


