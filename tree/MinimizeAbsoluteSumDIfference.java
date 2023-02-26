package LeetCode.tree;

import java.util.TreeSet;

public class MinimizeAbsoluteSumDIfference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //get the difference
        //then for each element search in treemap for element that will minimize difference
        int diff = 0, MOD = 1_000_000_007;
        for (int i = 0; i < nums1.length; i++) {
            diff += Math.abs(nums1[i] - nums2[i]);
            diff %= MOD;
        }
        TreeSet<Integer> set = new TreeSet<>();
        int originalDiff = diff;
        for (int i : nums1) set.add(i);
        for (int i = 0; i < nums1.length; i++) {
            Integer min = set.floor(nums2[i]);
            if (min != null) {
                diff = Math.min(diff, originalDiff - Math.abs(nums2[i] - nums1[i]) + Math.abs(nums2[i] - set.floor(nums2[i])));
            }
            Integer max = set.ceiling(nums2[2]);
            if (max != null) {
                diff = Math.min(diff, originalDiff - Math.abs(nums2[i] - nums1[i]) + Math.abs(nums2[i] - set.ceiling(nums2[i])));
            }
        }
        return diff >= 0 ? diff : diff + MOD;
    }


    public static void main(String[] args) {
        System.out.println(new MinimizeAbsoluteSumDIfference().minAbsoluteSumDiff(new int[]{1, 7, 5},
                new int[]{2, 3, 5}));
    }
}
