package LeetCode.string;

import java.util.Arrays;

//link - https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {


    public static void main(String[] args) {
        FirstUniqueCharacterInAString fuc = new FirstUniqueCharacterInAString();
        System.out.println(fuc.firstUniqChar("aabb"));
    }


    //O(n) time and O(1) space
    public int firstUniqChar(String s) {
        int[] occurrences = new int[27];
        int[] firstIndex = new int[27];
        Arrays.fill(firstIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            occurrences[s.charAt(i) - 'a' + 1]++;
            if (firstIndex[s.charAt(i) - 'a' + 1] == -1) firstIndex[s.charAt(i) - 'a' + 1] = i;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            if (occurrences[i] == 1) min = Math.min(min, firstIndex[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
