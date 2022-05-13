package LeetCode.myImpls;

//link - https://leetcode.com/problems/binary-search/solution/
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + ((right - left) / 2);
            //або можна - int mid = (low + high) >>> 1;
            // int mid =(low + high) / 2; - так не можна, тому що набагато більша ймовірність що low + high буде більше Integer.MAX_VALUE - і піде в мінус
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
