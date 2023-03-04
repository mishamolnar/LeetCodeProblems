package LeetCode.arrays;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        //brute force -> n2 complexity, iterate through each subarray and check min and max elements
        //optimized
        //maintaining 2 invariants -> last valid, last invalid
        //each time (num in (minK, maxK)) we can possibly increase last valid with sliding window
        //each time (num in (< minK || >maxK)) last invalid = i, last valid = i;
        //if numMin > 0 && numMax > 0 res += (lastvalid - lastInvalid);
        long res = 0, numMin = 0, numMax = 0;
        int lastValid = 0, lastInvalid =  -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == maxK) {
                numMax++;
            }
            if (curr == minK) {
                numMin++;
            } else if (curr < minK || curr > maxK) {
                lastInvalid = i;
                lastValid = i;
                numMin = 0;
                numMax = 0;
            }
            while (lastValid <= i &&
                    ((nums[lastValid] != minK && nums[lastValid] != maxK)
                            || (nums[lastValid] == maxK && numMax > 1)
                            || (nums[lastValid] == minK && numMin > 1))) {
                numMin -= nums[lastValid] == minK ? 1 : 0;
                numMax -= nums[lastValid] == maxK ? 1 : 0;
                lastValid++;
            }
            if (numMin > 0 && numMax > 0) {
                res += (lastValid - lastInvalid);
            }
        }
        return res;
    }
}
