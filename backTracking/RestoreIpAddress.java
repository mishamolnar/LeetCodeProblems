package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, new StringBuilder(), 0, 4, res);
        return res;
    }

    private void backtrack(String s, StringBuilder sb, int index, int remains, List<String> res) {
        if (remains == 0 && index == s.length()) {
            res.add(sb.toString());
        } else if (index < s.length()) {
            int i = index + 1;
            while (i <= s.length() && (Integer.parseInt(s.substring(index, i)) <= 255 && (i - index == 1 || s.charAt(index) != '0'))) {
                backtrack(s, new StringBuilder(sb).append(s.substring(index, i)).append(remains > 1 ? "." : ""), i, remains - 1, res);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddress restoreIpAddress = new RestoreIpAddress();
        System.out.println(restoreIpAddress.restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddress.restoreIpAddresses("0000"));
    }
}
