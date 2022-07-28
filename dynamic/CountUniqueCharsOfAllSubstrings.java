package LeetCode.dynamic;

import java.util.Arrays;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class CountUniqueCharsOfAllSubstrings {

    //O(n) time and constant space complexity
    public int uniqueLetterString(String s) {
        int[] last = new int[26];
        int[] prevLast = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(prevLast, -1);
        int sum = 0, curr = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            curr += (i - last[c] - 1) - (last[c] - prevLast[c]) + 1;
            sum += curr;

            prevLast[c] = last[c];
            last[c] = i;
        }
        return sum;
    }

    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        CountUniqueCharsOfAllSubstrings chars = new CountUniqueCharsOfAllSubstrings();
        chars.uniqueLetterString("EACDABA");
    }

}
