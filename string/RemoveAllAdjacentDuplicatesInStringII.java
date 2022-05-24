package LeetCode.string;

import java.util.Arrays;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII remove = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(remove.removeDuplicates("deeedbbcccbdaa", 3));
    }


    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int[] counts = new int[s.length()];
        counts[0] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++, res++) {
            arr[res] = arr[i];
            if (res > 0 && arr[i] == arr[res - 1]) {
                counts[res] = counts[res - 1] + 1;
            } else counts[res] = 1;
            if (counts[res] == k) res -= k;
        }
        return new String(arr, 0, res);
    }
}
