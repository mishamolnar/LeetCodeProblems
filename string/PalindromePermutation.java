package LeetCode.string;

//https://leetcode.com/problems/palindrome-permutation/
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[27];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
