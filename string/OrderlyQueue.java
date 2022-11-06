package LeetCode.string;

import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k > 1) return getMin(s);
        String res = s;
        for (int i = 0; i < s.length(); i++) {
            String buff = s.substring(1, s.length()) + s.charAt(0);
            if (buff.compareTo(res) < 0) res = buff;
        }
        return res;
    }

    private String getMin(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
