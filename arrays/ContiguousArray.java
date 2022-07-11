package LeetCode.arrays;

import java.util.HashMap;

//https://leetcode.com/problems/contiguous-array/solution/
public class ContiguousArray {

    //hashmap count of (ones count) - zeros -> index
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ones = 0, zeros = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else ones++;
            if (map.containsKey(ones - zeros)) ans = Math.max(ans, i - map.get(ones - zeros) + 1);
            map.putIfAbsent(ones - zeros, i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(String.format("%sz %do", 0, 0));
        ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(new int[]{0,1,0}));
    }
}
