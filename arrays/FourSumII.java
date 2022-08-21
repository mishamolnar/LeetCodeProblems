package LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = createHashTable(nums1, nums2);
        Map<Integer, Integer> map2 = createHashTable(nums3, nums4);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            res += entry.getValue() * map2.getOrDefault(- entry.getKey(), 0);
        }
        return res;
    }

    private Map<Integer, Integer> createHashTable(int[] nums1, int[] nums2) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                res.put(k + i, res.getOrDefault(k + i, 0) + 1);
            }
        }
        return res;
    }

    public int fourSumCountII(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}
