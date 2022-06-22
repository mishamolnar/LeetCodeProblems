package LeetCode.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//
public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        String s1 = "yes";
        s1.concat("234");
        System.out.println(s1);
        int[] d = {1, 2, 3};
        new String("adf");
    }


    public int longestRepeatingSubstring(String s) {
        int left = 1, right = s.length(), ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasDupe(mid, s)) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }

    private boolean hasDupe(int len, String s) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i + len <= s.length(); i++) {
            String buff = s.substring(i, i + len);
            int code = buff.hashCode();
            if (set.contains(code)) return true;
            set.add(code);
        }
        return false;
    }
}
