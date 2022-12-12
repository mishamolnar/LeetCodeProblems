package LeetCode.greedy;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToMakeArraysUnequal {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        long res = 0, toSwap = 0, maxSingle = 0;
        int single = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
                toSwap++;
                if (map.get(nums1[i]) > maxSingle) {
                    maxSingle = map.get(nums1[i]);
                    single = nums1[i];
                 }
                res += i;
            }
        }
        for (int i = 0; i < nums1.length && maxSingle > toSwap / 2; i++) {
            if (nums1[i] != single && nums1[i] != nums2[i] && nums2[i] != single) {
                res += i;
                toSwap++;
            }
        }
        return maxSingle > toSwap / 2 ? -1 : res;
    }
}
