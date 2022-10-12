package LeetCode.backTracking;

import LeetCode.heap.MaximumNumberOfEatenApples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOffConcatenatedString {
    public int maxLength(List<String> arr) {
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            if (!uniqueChars(s))
                continue;
            Set<String> curr = new HashSet<>();
            for (String s1 : set) {
                if (!intersects(s1, s))
                    curr.add(s1 + s);
            }
            set.add(s);
            set.addAll(curr);
        }
        return set.stream().max((a, b) -> Integer.compare(a.length(), b.length())).orElseGet(() -> "").length();
    }

    private boolean intersects(String a, String b) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (arr[b.charAt(i) - 'a'])
                return true;
        }
        return false;
    }

    private boolean uniqueChars(String s) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'])
                return false;
            arr[s.charAt(i) - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        MaxLengthOffConcatenatedString max = new MaxLengthOffConcatenatedString();
        System.out.println(max.maxLength(List.of("aa", "bb")));
        System.out.println(max.maxLength(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
    }
}
