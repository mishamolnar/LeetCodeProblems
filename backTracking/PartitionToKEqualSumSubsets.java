package LeetCode.backTracking;

import java.util.Arrays;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
public class PartitionToKEqualSumSubsets {
    //k * 2^n times (2^n to find each subset)
    public boolean canPartitionKSubsets(int[] A, int k) {
        if (k > A.length) return false;
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        return dfs(A, 0, A.length - 1, visited, sum / k, k);
    }

    public boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round) {
        if (round == 0) return true;
        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
            return true;
        for (int i = st; i >= 0; --i) { //2^n times to find each subset
            if (!visited[i] && sum + A[i] <= target) {
                visited[i] = true;
                if (dfs(A, sum + A[i], i - 1, visited, target, round))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
