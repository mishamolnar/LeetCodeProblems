package LeetCode.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/next-palindrome-using-same-digits/submissions/
public class NextPalindromeUsingSameDigits {

    //O(n) time and space
    public String nextPalindrome(String num) {
        if (num.length() < 3) return num;
        StringBuilder sb = new StringBuilder(getNextMax(num.substring(0, num.length() / 2)));
        if (sb.length() == 0) return sb.toString();
        if (num.length() % 2 == 1) sb.append(num.charAt(num.length() / 2));
        for (int i = sb.length() - 1 - (num.length() % 2); i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }

    private String getNextMax(String half) {
        char[] arr = half.toCharArray();
        int small = -1, big = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                small = i - 1;
            }
            if (small != -1 && arr[i] > arr[small]) {
                big = i;
            }
        }
        if (small == -1) return "";
        char buff = arr[big];
        arr[big] = arr[small];
        arr[small] = buff;
        Arrays.sort(arr, small + 1, arr.length);
        return new String(arr);
    }

    public static void main(String[] args) {
        NextPalindromeUsingSameDigits nextPalindromeUsingSameDigits = new NextPalindromeUsingSameDigits();
        System.out.println(nextPalindromeUsingSameDigits.nextPalindrome("45544554"));

    }
}
