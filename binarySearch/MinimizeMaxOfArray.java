package LeetCode.binarySearch;

import java.util.Arrays;

public class MinimizeMaxOfArray {


    //prefix
    public int minimizeArrayValue(int[] nums) {
        int res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = (int) Math.max(res, (sum / (i + 1)) + ((sum % (i + 1)) == 0 ? 0 : 1));
        }
        return res;
    }


    //binary search
    public int minimizeArrayValueBin(int[] nums) {
        int left = -1, right = Arrays.stream(nums).max().getAsInt() + 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (test(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean test(int[] nums, int target) {
        long num = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            num = Math.min(0, num + target - nums[i]);
        }
        return num >= 0 && target >= nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new MinimizeMaxOfArray().minimizeArrayValue(new int[]{4,7,2,2,9,19,16,0,3,15}));
    }
}
