package LeetCode.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/submissions/
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                                                'C', 100, 'D', 500, 'M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1))) sum -= dict.get(s.charAt(i));
            else sum += dict.get(s.charAt(i));
        }
        return sum;
    }
}
