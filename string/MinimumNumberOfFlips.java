package LeetCode.string;

//link - https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
//complexity time O(n) and space O(1) because we use indexes
public class MinimumNumberOfFlips {

    public int minFlips(String s) {
        int result = Integer.MAX_VALUE;
        int count10 = 0;
        int count01 = 0;
        int len = s.length();
        for (int i = 0; i < len * 2; i++) {
            if ((i % 2 == 0 && s.charAt(i % len) == '1') || (i % 2 == 1 && s.charAt(i % len) == '0')) {
                count01++;
            } else count10++;
            if (i >= len) {
                if (((i - len) % 2 == 0 && s.charAt(i % len) == '1') || ((i - len) % 2 == 1 && s.charAt(i % len) == '0')) {
                    count01--;
                } else count10--;
                result = Math.min(result, Math.min(count01, count10));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfFlips minimumNumberOfFlips = new MinimumNumberOfFlips();
        minimumNumberOfFlips.minFlips("111000");
    }
}
