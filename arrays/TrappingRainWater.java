package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/trapping-rain-water/submissions/
public class TrappingRainWater {

    public int trap(int[] height) {
        int res = 0, level = 0, left = 0, right = height.length - 1;
        while (left <= right) {
            if (Math.min(height[left], height[right]) > level) {
                res += (right - left + 1) * (Math.min(height[left], height[right])  - level);
                level = Math.min(height[left], height[right]);
            }
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res - Arrays.stream(height).sum();
    }

    //O(n) space and time
    public int trapTwo(int[] height) {
        int[] res = new int[height.length];
        int prevMax = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            prevMax = Math.max(prevMax, height[i]);
            res[i] = prevMax;
        }
        prevMax = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i++) {
            prevMax = Math.max(prevMax, height[i]);
            res[i] = Math.min(prevMax, res[i]);
        }
        return Arrays.stream(res).sum() - Arrays.stream(height).sum();
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
