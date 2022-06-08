package LeetCode.string;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/string-transforms-into-another-string/
public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)) return false;
            map.put(str1.charAt(i), str2.charAt(i));
            set.add(str2.charAt(i));
        }

        return set.size() < 26;
    }


    public static void main(String[] args) {
        StringTransformsIntoAnotherString string = new StringTransformsIntoAnotherString();
        System.out.println(string.canConvert("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
    }
}
