package LeetCode.dynamic;

//link - https://leetcode.com/problems/decode-ways/
public class DecodeWays {


    //time limit exceeted
    //time comp - 2^n
    public int numDecodingsWithHelper(String s) {
        if (s.length() == 0) return 0;
        return helper(s, 0);
    }

    private int helper(String s, int start) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0; // нова стрінга починається на нулі, тому без варіантів
        int res = helper(s, start + 1);
        if (start < s.length() - 1 && (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7'))) {
            res += helper(s, start + 2);
        }
        return res;
    }

    //memoization
    // O(n) - time
    // O(n) space
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        if (s.length() == 0) return 0;
        return helperMemo(s, memo, 0);
    }

    private int helperMemo(String s, Integer[] memo, int start) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        if (memo[start] != null) return memo[start];
        int res = helperMemo(s, memo, start + 1);
        if (start < s.length() - 1 && (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7'))) {
            res += helperMemo(s, memo, start + 2);
        }
        return memo[start] = res;
    }


    //memoization
    // O(n) - time
    // O(n) space
    // iterative, no recursion
    private int numDecodingsIterative(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    // no extra space
    // O(n) time
    private int numDecodingNoMemo(String s) {
        if (s.length() == 0) return 0;
        int prevOne = 1; //constantly 1 step ahead
        int prevTwo = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int tmp = s.charAt(i) != '0' ? prevOne : 0; //we can't continue if current string started from 0
            if (i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' &&  s.charAt(i + 1) < '7'))) {
                tmp += prevTwo; //if number is 10-26 -> then we need to add prev previous number
            }
            prevTwo = prevOne;
            prevOne = tmp;
        }
        return prevOne;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodingNoMemo("120341023423221"));
    }
}
