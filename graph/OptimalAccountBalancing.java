package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/optimal-account-balancing/
public class OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebtArray(transactions); // Debt amount to balance for each person.

        return getMinTransfersAfter(0, debt);
    }

    private int getMinTransfersAfter(int curId, int[] debt) {
        while (curId < debt.length && debt[curId] == 0) //шукаємо того в кого є борг, або кому винні (не нульовий)
            curId++;
        // Base case.
        if (curId == debt.length) //якщо такого не знайшли і проітерувались до кінця масиву - повертаємо нуль (нічого міняти)
            return 0;
        // Recursive case.
        int minTransactions = Integer.MAX_VALUE;
        for (int i = curId + 1; i < debt.length; i++) {
            if (debt[i] * debt[curId] < 0) { //починаємо з знайденого елементу йти на право і шукати елемент протилежній за знаком (debt[i] * debt[curId] < 0)
                // One has to pay and the other has to receive
                // Say currentIndex has to receive -> i has to pay
                debt[i] += debt[curId];
                minTransactions = Math.min(minTransactions, getMinTransfersAfter(curId + 1, debt) + 1); //до того елементу що знайшли справа додаємо поточний елемент і важаємо що зліва все всі заплатили
                debt[i] -= debt[curId];
            }
        }

        return minTransactions;
    }

    private int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>(); // Map person ID to debt amount.

        for (int[] transaction : transactions) {
            int giver = transaction[0];
            int taker = transaction[1];
            int amount = transaction[2];
            debtMap.put(giver, debtMap.getOrDefault(giver, 0) + amount);
            debtMap.put(taker, debtMap.getOrDefault(taker, 0) - amount);
        }

        int[] debt = new int[debtMap.size()];
        int i = 0;
        for (int amount : debtMap.values()) {
            debt[i++] = amount;
        }

        return debt;
    }

    public int minTransfersTLE(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        ArrayList<Integer> all = (ArrayList<Integer>) map.values().stream().filter(n -> n != 0).sorted().collect(Collectors.toList());
        int res = all.size() - numberOfWeighted(all.stream().mapToInt(i -> i).toArray(), new boolean[all.size()], 0, all.size());
        return Math.max(res, 0);
    }

    //backtracking TLE
    private int numberOfWeighted(int[] all, boolean[] used, int currSum, int remains) {
        int max = 0, increment = 0;
        if (remains == 0) {
            return 1;
        } else if (currSum == 0 && remains < all.length) {
            increment = 1;
        }
        for (int j = 0; j < all.length; j++) {
            if (used[j]) continue;
            used[j] = true;
            max = Math.max(max, increment + numberOfWeighted(all, used, currSum + all[j], remains - 1));
            used[j] = false;
        }
        return max;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing optimal = new OptimalAccountBalancing();
        System.out.println(optimal.minTransfers(new int[][]{{0,1,10},{1,0,1},{1,2,5},{2,0,5}}));
    }
}


