package LeetCode.dynamic;


//link - https://leetcode.com/problems/jump-game/
public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJumpIterable(new int[]{3,2,1,0,4}));
    }

    //dp time O(n) space - O(1) greedy
    public boolean CanJumpDp(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            if (i == 0) max = nums[i];
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

    //top down memo iterable
    //O(n) time and space
    public boolean canJumpIterable(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        memo[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums[i]; j >= 0; j--) {
                if (i + j <= nums.length - 1 && memo[i + j] != null && memo[i + j]) {
                    memo[i] = true;
                    break;
                }
            }
            if (memo[i] == null) memo[i] = false;
        }
        return memo[0];
    }


    // O(n) time and space
    public boolean canJumpMemo(int[] nums) {
        Boolean[] visited = new Boolean[nums.length];
        return memoRecursionHelper(nums, visited, 0);
    }

    private boolean memoRecursionHelper(int[] nums, Boolean[] memo, int current) {
        if (current == nums.length - 1) return true;
        if (current > nums.length - 1) return false;
        if (memo[current] != null) return memo[current];
        for (int i = 1; i < nums[current]; i++) {
            if (memoRecursionHelper(nums, memo, current + i)) {
                memo[current] = true;
                return true;
            }
        }
        memo[current] = false;
        return false;
    }

    //with naive recursion - time complexity O(s^n) where s - average jump length in array
    public boolean canJump(int[] nums) {
        return naiveRecursionHelper(nums, 0);
    }

    private boolean naiveRecursionHelper(int[] nums, int current) {
        if (current == nums.length - 1) return true;
        if (current > nums.length - 1) return false;
        for (int i = 1; i <= nums[current]; i++) {
            if (naiveRecursionHelper(nums, current + i)) return true;
        }
        return false;
    }
}
