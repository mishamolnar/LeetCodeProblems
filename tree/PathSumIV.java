package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/path-sum-iv/
public class PathSumIV {
    public static void main(String[] args) {
        PathSumIV pathSumIV = new PathSumIV();
        System.out.println(pathSumIV.pathSum(new int[]{113,215,221}));
    }

    private int sum = 0;

    public int pathSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num / 10, num % 10);
        dfs(map, nums[0] / 10);
        return sum;
    }

    private int dfs(HashMap<Integer, Integer> map, Integer current) {
        if (!map.containsKey(current)) return 0;
        int left = current + 9 + current % 10;
        int right = current + 10 + current % 10;
        int leftCount = dfs(map, left);
        int rightCount = dfs(map, right);
        int count = Math.max(leftCount + rightCount, 1);
        sum += count * map.get(current);
        return count;
    }
}
