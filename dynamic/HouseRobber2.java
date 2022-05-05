package LeetCode.dynamic;


//link - https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {

    // 0(2n) for naive recurrence solution
    public int robRecursion(int[] nums) {
        int[] memo = new int[nums.length + 1];
        return helper(nums, nums.length - 1, false);
    }

    private int helper(int[] nums, int start, boolean isFirstRobbed) {
        if (start < 0) return 0;
        if (start == nums.length - 1) {
            return Math.max(helper(nums, start - 1, isFirstRobbed), nums[start] + helper(nums, start - 2, true));
        }
        if (start == 0 && isFirstRobbed) {
            return 0;
        } else if (start == 0) {
            return nums[start];
        }
        return Math.max(helper(nums, start - 1, isFirstRobbed), nums[start] + helper(nums, start - 2, isFirstRobbed));
    }

    // time - O(2n) -> O(n)
    // space - O(1)
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 1 , nums.length), rob(nums, 0, nums.length - 1));
    }

    //bottom up constant space and linear time
    public int rob(int[] nums, int start, int end) {
        int prevOne = 0; // constantly bigger then another
        int prevTwo = 0;
        for (int i = start; i < end; i++) {
            int tmp = prevOne;
            prevOne = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = tmp;
        }
        return prevOne;
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        System.out.println(houseRobber2.rob(new int[]{2, 2, 4, 3, 2, 5}));
    }
}
