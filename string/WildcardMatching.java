package LeetCode.string;

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {

    //O(nm)
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (dp[i][j]) {
                    if (p.charAt(j) == '?' ||
                        (Character.isAlphabetic(p.charAt(j)) && p.charAt(j) == s.charAt(i))) {
                        dp[i + 1][j + 1] = true;
                    } else if (p.charAt(j) == '*') {
                        dp[i + 1][j + 1] = true;
                        dp[i][j + 1] = true;
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        int last = p.length();
        do {
            if (dp[s.length()][last]) return true;
            last--;
        } while (last >= 0 && p.charAt(last) == '*');
        return false;
    }

    //tle
    public boolean isMatchDp(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int sP, String p, int pP) {
        if (sP >= s.length() && (pP >= p.length() || p.substring(pP).replace("*", "").isEmpty())) return true;
        else if (sP >= s.length() || pP >= p.length()) return false;

        if (p.charAt(pP) != '*') {
            if (Character.isAlphabetic(p.charAt(pP))
                    && s.charAt(sP) != p.charAt(pP)) return false;
            else return helper(s, sP + 1, p, pP + 1);
        }

        return helper(s, sP + 1, p, pP + 1)
                || helper(s, sP + 1, p, pP)
                || helper(s, sP, p, pP + 1);
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aa", "*"));
    }
}
