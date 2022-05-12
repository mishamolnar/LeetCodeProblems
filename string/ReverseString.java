package LeetCode.string;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char buff = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = buff;
        }
    }
}
