package LeetCode.greedy;

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        char[] str = s.toCharArray();
        int max = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, calculateVariance(str, (char) ('a' + i), (char) ('a' + j)));
            }
        }
        return max;
    }

    private int calculateVariance(char[] s, char one, char two) {
        int count = 0, max = 0;
        boolean firstTwo = false, hasTwo = false;
        for (char curr : s) {
            count += (curr == one) ? 1 : 0;
            if (curr == two) {
                hasTwo = true;
                if (firstTwo && count >= 0) {
                    firstTwo = false;
                } else if (--count < 0) {
                    firstTwo = true;
                    count = -1;
                }
            }
            if (hasTwo)
                max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        SubstringWithLargestVariance substring = new SubstringWithLargestVariance();
        System.out.println(substring.calculateVariance("ababbb".toCharArray(), 'b', 'a'));
    }
}
