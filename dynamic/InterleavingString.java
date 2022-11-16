package LeetCode.dynamic;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (dp[i][j] && j < s1.length() && (s1.charAt(j) == s3.charAt(i + j)))
                    dp[i][Math.min(j + 1, s1.length())] = true;
                if (dp[i][j] && i < s2.length() && s2.charAt(i) == s3.charAt(i + j))
                    dp[Math.min(i + 1, s2.length())][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString string = new InterleavingString();
        System.out.println(string.isInterleave("aa", "ab", "abaa"));
        System.out.println(string.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
