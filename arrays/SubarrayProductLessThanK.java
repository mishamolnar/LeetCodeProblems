package LeetCode.arrays;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, sum = 1, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k && left <= right) {
                sum /= nums[left++];
            }
            if (sum < k) res += (right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
