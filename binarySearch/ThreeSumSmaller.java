package LeetCode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller/solution/
public class ThreeSumSmaller {
    public static void main(String[] args) {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        System.out.println(threeSumSmaller.binarySearch(new int[]{-1, -1, -1, 1}, 1, 2));
        System.out.println(threeSumSmaller.threeSumSmaller(new int[]{-1, -1, -1, 1}, -1));
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = binarySearch(nums, target - nums[i] - nums[j], j + 1);
                if (nums[i] + nums[j] + nums[index] < target) res += index - j;
            }
        }
        return res;
    }

    //returns an index of the numbers, that is less then target
    private int binarySearch(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
