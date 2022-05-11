package LeetCode.string;

// link - https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.cleanString("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindromeTwoPointers(".,"));
    }

    // O(n) time and constant space
    public boolean isPalindromeTwoPointers(String s) {
        if (s.length() < 2) return true;
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            while (start < s.length() - 1 && !Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) start++;
            while (end >= 0 && !Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) end--;
            if (end < 0 || start >= s.length()) return true;
            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) return false;
        }
        return true;
    }


    // O(n) time and space
    public boolean isPalindrome(String s) {
        String tide = cleanString(s);
        for (int i = 0; i < tide.length() / 2 + 1; i++) {
            if (tide.charAt(i) != tide.charAt(tide.length() - 1 - i)) return false;
        }
        return true;
    }

    private String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c > 96 && c < 123) || (c < 58 && c > 47)) sb.append(c);
            else if (c + 32 > 96 && c + 32 < 123) sb.append((char) (c + 32));
        }
        return sb.toString();
    }
}
