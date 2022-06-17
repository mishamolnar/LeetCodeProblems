package LeetCode.string;

import java.util.Arrays;

//https://leetcode.com/problems/add-bold-tag-in-string/submissions/
public class AddBoldTagInString {








    public String addBoldTagTwo(String s, String[] words) {
        boolean[] dp = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            dp[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] && (i == 0 || !dp[i - 1])) sb.append("<b>");
            if (!dp[i] && i > 0 && dp[i - 1]) sb.append("</b>");
            sb.append(s.charAt(i));
            if (i == s.length() - 1 && dp[i]) sb.append("</b>");
        }
        return sb.toString();
    }



    //S - s.length
    //W - words length and V - word length in words
    // O(swv) - time comlexity and o(v) space
    public String addBoldTag(String s, String[] words) {
        boolean[] dp = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            dp[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && dp[j]) j++;
            result.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j - 1;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddBoldTagInString tagInString = new AddBoldTagInString();
        System.out.println(tagInString.addBoldTag("abcxyz123", new String[]{"abc", "123"}));
    }
}
