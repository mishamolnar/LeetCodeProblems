package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

// link - https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    //O(n log k) time and O(k) space, where k - answer
    public int lengthOfLISTwo(int[] nums) {
        ArrayList<Integer> tails = new ArrayList<>();
        for (int i : nums) {
            int index = getNextGreaterOrZero(tails, i);
            if (index == tails.size()) tails.add(i);
            else tails.set(getNextGreaterOrZero(tails, i), i);
        }
        return tails.size();
    }

    private int getNextGreaterOrZero(ArrayList<Integer> tails, int insert) {
        int left = 0, right = tails.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = tails.get(mid);
            if (val < insert) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }








    // Space complexity O(n)
    // Time complexity O(n^2 + n*log n) => O(n^2)
    //this is dynamic programming solution
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] lises = new int[nums.length];
        lises[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(lises[j] + 1, max);
                }
            }
            lises[i]= max;
        }
        Arrays.sort(lises);
        return lises[lises.length - 1];
    }

    public int lengthOfLisBinary(int[] nums) {
        int[] tails = new int[nums.length]; // останні цифри в зростаючих послідовностях, завжди є відсортованим в інтервалі 0 до size
        int size = 0;
        for (int num : nums) {
            int start = 0;
            int end = size;
            while (start != end) { //бінарний пошук по всьому заповненому масиві
                int mid = (start + end) / 2; // середина інтервала пошуку
                if (tails[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            tails[start] = num; // тут є два варіанти - ми могли обновити значення, яке було заповнене,
            // тобто воно не більше ніж максимум і мі просто зменшуємо макс значення поточноої довжини
            // або
            // наш num більше за всі інші значення в масиві tails і ми знайшли послідовність на один довшу ніж size
            if (start == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] ints = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLISTwo(ints));
    }
}
