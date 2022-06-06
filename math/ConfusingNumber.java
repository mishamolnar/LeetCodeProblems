package LeetCode.math;

import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/confusing-number/submissions/
public class ConfusingNumber {

    public boolean confusingNumber(int n) {
        String s = String.valueOf(n);
        if (s.length() == 0) return true;
        Map<Character, Character> set = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
        boolean symmetric = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.containsKey(c)) return false;
            if (s.charAt(s.length() - i - 1) != s.charAt(set.get(c))) symmetric = false;
        }
        return !symmetric;
    }

}
