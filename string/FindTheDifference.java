package LeetCode.string;


//https://leetcode.com/problems/find-the-difference/
public class FindTheDifference {
    public static void main(String[] args) {

    }

    public char findTheDifference(String s, String t) {
        int[] arr = new int[27];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) return t.charAt(i);
        }
        return 'a';
    }
}
