package LeetCode.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//
public class BurstBalloons {
    //n2 space
    //n3 time, тому що ми розглядаємо кожен підмасив (а їй є n2) для кожного елементу
    public int maxCoins(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, nums.length - 1, nums, memo);
    }

    private int dfs(int left, int right, int[] nums, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        int max = 0;
        for (int i = left; i <= right; i++) {
            int num = nums[i]
                    * (left > 0 ? nums[left - 1] : 1)
                    * (right < nums.length - 1 ? nums[right + 1] : 1);
            num += dfs(left, i - 1, nums, memo) + dfs(i + 1, right, nums, memo);
            max = Math.max(max, num);
        }
        memo[left][right] = max;
        return max;
    }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        System.out.println(burstBalloons.maxCoins(new int[]{3,1,5,8}));
    }
}
