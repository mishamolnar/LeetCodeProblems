package LeetCode.arrays;

//link - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArr {

    // time - O(n)
    // space - O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) left++;
            else if (numbers[left] + numbers[right] > target) right--;
            else return new int[]{left + 1, right + 1};
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {

    }
}
