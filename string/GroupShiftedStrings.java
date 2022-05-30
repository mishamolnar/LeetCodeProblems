package LeetCode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/group-shifted-strings/solution/
public class GroupShiftedStrings {

    //Let N be the length of strings and KK be the maximum length of a string in strings
    //worst case space and time complexity - O(NK)
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String key = formKey(string);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

    // Create a hash value
    String formKey(String s) {
        char[] chars = s.toCharArray();

        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        String hashKey = String.valueOf(chars);
        return hashKey;
    }
}
