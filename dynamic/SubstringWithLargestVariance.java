package LeetCode.dynamic;

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, kadane(s, (char) ('a' + i), (char) ('a' + j)));
            }
        }
        return max;
    }

    private int kadane(String s, char a, char b) {
        int curr = 0, max = 0;
        boolean firstB = false, hasB = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curr += c == a ? 1 : 0;
            if (c == b) {
                hasB = true;
                if (firstB && curr >= 0) {
                    firstB = false;
                } else if (--curr < 0) {
                    firstB = true;
                    curr = -1;
                }
            }
            if (hasB) max = Math.max(max, curr);
        }
        return max;
    }
}
