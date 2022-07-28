package LeetCode.graph;

//https://leetcode.com/problems/regular-expression-matching/solution/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int sPointer, String p, int pPointer) {
        if (pPointer >= p.length()) return sPointer >= s.length();

        boolean nextWildCard = pPointer + 1 < p.length() && p.charAt(pPointer + 1) == '*';
        boolean match = sPointer < s.length() &&
                (s.charAt(sPointer) == p.charAt(pPointer) || p.charAt(pPointer) == '.');

        if (nextWildCard) {
            return helper(s, sPointer, p, pPointer + 2)
                    || (match && helper(s, sPointer + 1, p, pPointer));
        } else {
            return match && helper(s, sPointer + 1, p, pPointer + 1);
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("a", "ab*"));
    }
}
