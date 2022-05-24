package LeetCode.dynamic;

import java.util.*;

//https://leetcode.com/problems/delete-and-earn/submissions/
public class DeleteAndEarn {

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarnConstantSpace(new int[]{8,10,4,9,1,3,5,9,4,10}));
        //System.out.println(deleteAndEarn.deleteAndEarn(new int[]{12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93}));
    }


    //doesn't work
    public int deleteAndEarnConstantSpace(int[] nums) {
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int prevOne = nums[0];
        int prevTwo = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + num);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                prevTwo = prevOne;
                prevOne += map.get(nums[i]);
            } else {
                prevOne = Math.max(prevTwo + map.get(nums[i]), prevOne);
                prevTwo = prevOne;
            }
        }
        return prevOne;
    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) != num) list.add(num);
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        int[] dp = new int[list.size()];
        return dynamic(map, list, dp, 0);
    }

    private int dynamic(HashMap<Integer, Integer> nums, List<Integer> list, int[] dp, int index) {
        if (index >= dp.length) return 0;
        if (dp[index] != 0) return dp[index];
        if (index >= dp.length - 1) return nums.get(list.get(list.size() - 1)) + dynamic(nums, list, dp, index + 1);
        dp[index] = Math.max(nums.get(list.get(index)) + dynamic(nums, list, dp, list.get(index + 1) >= list.get(index) + 2 ? index + 1 : index + 2), dynamic(nums, list, dp, index + 1));
        return dp[index];
    }
}
