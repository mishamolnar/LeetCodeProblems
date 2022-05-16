package LeetCode.string;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        System.out.println(reverseVowelsOfString.reverseVowels("aA"));
    }

    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] result = s.toCharArray();
        while (left < right) {
            if (isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                result[right] = s.charAt(left);
                result[left] = s.charAt(right);
                left++;
                right--;
            }
            if (!isVowel(s.charAt(left))) left++;
            if (!isVowel(s.charAt(right))) right--;
        }
        return String.valueOf(result);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o' || c == 'A' || c == 'E' || c == 'I' || c == 'U' || c == 'O';
    }
}
