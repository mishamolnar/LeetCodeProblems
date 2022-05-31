package LeetCode.arrays;

//https://leetcode.com/problems/range-addition/
public class RangeAddition {

    // O(1) space complexity
    // O(n + k) time where n - length and k - length of updates
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            arr[update[0]] += update[2];
            if (update[1] < length - 1) arr[update[1] + 1] -= update[2];
        }
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            arr[i] = curr;
        }
        return arr;
    }
}
