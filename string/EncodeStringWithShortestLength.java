package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95602/Short-Python
public class EncodeStringWithShortestLength {

    //dp[i][j] = string from index i to index j in encoded form.
    //O(n)
    //"abbbabbbcabbbabbbc" -> "2[2[abbb]c]"
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

    public static String encode1(String s, Map<String, String> map) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() <= 4) return s; //adding this further reduces the runtime from 168 ms to 134 ms
        int n = s.length();
        int i = (s + s).indexOf(s, 1);
        String one = i < n ? String.format("%d[%s]", n / i, encode1(s.substring(0, i), map)) : s;
        List<String> multi = new ArrayList<>(Arrays.asList(one));
        for (int j = 1; j < n; j++) multi.add(encode1(s.substring(0, j), map) + encode1(s.substring(j), map));
        String res = multi.stream().min(Comparator.comparingInt(String::length)).get();
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        EncodeStringWithShortestLength encodeStringWithShortestLength = new EncodeStringWithShortestLength();
        System.out.println(encodeStringWithShortestLength.encode("abbbabbbcabbbabbbc"));
    }
}
