package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95602/Short-Python
public class EncodeStringWithShortestLength {

    //dp[i][j] = string from index i to index j in encoded form.
    //O(n)
    //"abbbabbbcabbbabbbc" -> "2[2[abbb]c]"
    //dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int currEnd = i + l;
                String substring = s.substring(i, currEnd + 1);

                if (currEnd - i < 4) {
                    dp[i][currEnd] = substring;
                } else {
                    dp[i][currEnd] = substring;
                    for (int k = i; k < currEnd; k++) {
                        if (dp[i][k].length() + dp[k + 1][currEnd].length() < dp[i][currEnd].length()) {
                            dp[i][currEnd] = dp[i][k] + dp[k + 1][currEnd];
                        }
                    }

                    for (int k = 0; k < substring.length(); k++) {
                        String pattern = substring.substring(0, k + 1);
                        if (substring.length() % pattern.length() == 0
                                && substring.replace(pattern, "").length() == 0) {
                            String encoded = substring.length() / pattern.length() + "[" +  dp[i][i + k] + "]";
                            if (encoded.length() < dp[i][currEnd].length()) {
                                dp[i][currEnd] = encoded;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        EncodeStringWithShortestLength encodeStringWithShortestLength = new EncodeStringWithShortestLength();
        System.out.println(encodeStringWithShortestLength.encode("abbbabbbcabbbabbbc"));
    }
}
