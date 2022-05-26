package LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/strobogrammatic-number/submissions/
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = Map.of('6', '9', '8', '8', '9', '6', '0', '0', '1', '1');
        for (int i = 0; i < num.length() / 2 + 1; i++) {
            char c = num.charAt(i);
            if (!map.containsKey(c) || map.get(c) != num.charAt(num.length() - 1 - i)) return false;
        }
        return true;
    }
}
