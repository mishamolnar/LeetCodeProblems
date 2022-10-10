package LeetCode.string;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int res = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                curr++;
                res = Math.max(res, curr);
            } else curr = 1;
        }
        return curr;
    }

    public static void main(String[] args) {
        LengthOfTheLongestAlphabeticalContinuousSubstring length = new LengthOfTheLongestAlphabeticalContinuousSubstring();
        System.out.println(length.longestContinuousSubstring("abacaba"));
    }
}
