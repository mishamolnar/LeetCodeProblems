package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/strobogrammatic-number-ii/solution/
public class StrobogrammaticNumberII {

    public static void main(String[] args) {
        StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
        System.out.println(strobogrammaticNumberII.findStrobogrammatic(3));
    }


    public List<String> findStrobogrammatic(int n) {
        if (n == 1) return List.of("0", "1", "8");
        Map<Character, Character> map = Map.of('6', '9', '8', '8', '9', '6', '0', '0', '1', '1');
        List<Character> available = List.of('0', '1', '6', '8', '9');
        List<String> result = new ArrayList<>();
        List<StringBuilder> res = new ArrayList<>();
        getAllPermutations(res, new StringBuilder(), n, available);
        for (StringBuilder re : res) {
            result.add(extend(re, map, n));
        }
        return result;
    }

    private String extend(StringBuilder sb, Map<Character, Character> map, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            sb.append(map.get(sb.charAt(i)));
        }
        return sb.toString();
    }

    private void getAllPermutations(List<StringBuilder> res, StringBuilder curr, int n, List<Character> available) {
        if (curr.length() == (n % 2 == 1 ? n / 2 + 1 : n / 2)) res.add(curr);
        else {
            for (Character c : available) {
                if (curr.length() == 0 && c == '0') continue;
                if ( n % 2 == 1 && curr.length() == n / 2 && (c == '9' || c == '6')) continue;
                curr.append(c);
                getAllPermutations(res, new StringBuilder(curr), n, available);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

}
