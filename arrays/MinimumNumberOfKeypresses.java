package LeetCode.arrays;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/minimum-number-of-keypresses/
public class MinimumNumberOfKeypresses {
    public int minimumKeypresses(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < 8) sum += arr[i] * 3;
            else if (i < 17) sum += (arr[i] * 2);
            else sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumNumberOfKeypresses minimum = new MinimumNumberOfKeypresses();
        minimum.minimumKeypresses("abcdefghijkl");
    }
}
