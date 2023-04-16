package LeetCode.dynamic;

import java.util.Arrays;
import java.util.List;

public class MaximumValuesOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for (int currentCoins = 0; currentCoins <= Math.min((int)piles.get(i - 1).size(), coins); currentCoins++) {
                    if (currentCoins > 0) {
                        currentSum += piles.get(i - 1).get(currentCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
                }
            }
        }
        return dp[n][k];
    }

    public int maxValueOfCoinsInvalid(List<List<Integer>> piles, int k) {
        int[][] prefixSums = new int[piles.size()][];
        for (int i = 0; i < prefixSums.length; i++) {
            prefixSums[i] = new int[piles.get(i).size()];
            int sum = 0;
            for (int j = 0; j < piles.get(i).size(); j++) {
                sum += piles.get(i).get(j);
                prefixSums[i][j] = sum;
            }
        }
        int[] tops = new int[piles.size()];
        int res = 0;
        for (int i = 0; i < k; i++) {
            int newRes = res;
            int[] newTops = new int[piles.size()];
            for (int j = 0; j < piles.size(); j++) {
                if (i < prefixSums[j].length && prefixSums[j][i] > newRes) {
                    newRes = prefixSums[j][i];
                    Arrays.fill(newTops, 0);
                    newTops[j] = i + 1;
                }
                if (tops[j] < piles.get(j).size() && piles.get(j).get(tops[j]) + res > newRes) {
                    newRes = piles.get(j).get(tops[j]) + res;
                    newTops = tops.clone();
                    newTops[j]++;
                }
            }
            res = newRes;
            tops = newTops;
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new MaximumValuesOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(100), List.of(100), List.of(100), List.of(100), List.of(100), List.of(100), List.of(1,1,1,1,1,1,700)), 7));
        System.out.println(new MaximumValuesOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(80,62,78,78,40,59,98,35),
                List.of(79,2,27,73,12,13,11,37,27,55,54,55,87,10,97,26,78,20,75,23,46,94,56,32,14,70,70,37,60,46,1,53),
                List.of(79,19,100,15)), 25));
        //not valid solution because of this testcase, 35 and 15 from first lists will be added, because they are greater then 10 in last one.
        //but the optimal solution will not contain 15 and 25, but 10, 97 instead
        //this implementation cannot check this


    }
}
