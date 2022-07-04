package LeetCode.dynamic;

//https://leetcode.com/problems/partition-equal-subset-sum/submissions/
public class PartitionEqualSubsetSum {

    //O(nm) space and time complexity
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[][] arr = new boolean[nums.length + 1][target + 1];
        for (boolean[] booleans : arr) booleans[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < target; j++) {
                if (!arr[i][j]) continue;
                arr[i + 1][j] = true;
                int tar = j + nums[i];
                if (tar == target) return true;
                if (tar > target) continue;
                arr[i + 1][j + nums[i]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 2, 5}));
    }
}
