package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/confusing-number-ii/
public class ConfusingNumberII {
    Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
    int res = 0;

    public int confusingNumberII(int n) {
        helper(n, 0);
        return this.res;
    }

    private void helper(int N, long curr) {
        if (isConfusingNumber(curr)) {
            this.res++;
        }
        for (Integer i : map.keySet()) {
            if (curr * 10 + i <= N && curr * 10 + i != 0) {
                helper(N, curr * 10 + i);
            }
        }
    }

    private boolean isConfusingNumber(long n) {
        long src = n;
        long ans = 0;
        while (n > 0) {
            ans = ans * 10 + map.get((int) n % 10);
            n /= 10;
        }
        return ans != src;
    }

    //time limit exceeded
    public int confusingNumberIITLE(int n) {
        Map<Character, Character> map = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
        List<Integer> result = new ArrayList<>();
        backtrack(map, result, String.valueOf(n).length(), new StringBuilder());
        return (int) result.stream().filter(a -> a <= n && a >= 1).count();
    }

    private void backtrack(Map<Character, Character> map, List<Integer> result, int remains, StringBuilder current) {
        if (remains == 0) {
            int num = Integer.parseInt(current.toString());
           if (confusingNumber(num)) result.add(num);
        } else {
            for (Character c : map.keySet()) {
                current.append(c);
                backtrack(map, result, remains - 1, new StringBuilder(current));
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public boolean confusingNumber(int n) {
        String s = String.valueOf(n);
        if (s.length() == 0) return true;
        Map<Character, Character> set = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
        boolean symmetric = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.containsKey(c)) return false;
            if (s.charAt(s.length() - i - 1) != set.get(c)) symmetric = false;
        }
        return !symmetric;
    }

    public static void main(String[] args) {
        ConfusingNumberII confusingNumberII = new ConfusingNumberII();
        System.out.println(confusingNumberII.confusingNumberII(20));
    }
}
