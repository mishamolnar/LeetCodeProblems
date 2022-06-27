package LeetCode.string;

//string - O(n) time
//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[60];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        boolean odd = false;
        int sum = 0;
        for (int i = 0; i < 60; i++) {
            if (arr[i] % 2 == 0 || arr[i] > 2) sum += arr[i] % 2 == 0 ? arr[i] : arr[i] - 1;
            if (arr[i] % 2 == 1) odd = true;
        }
        return sum + (odd ? 1 : 0);
    }
}
