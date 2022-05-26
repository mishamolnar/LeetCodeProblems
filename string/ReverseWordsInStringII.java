package LeetCode.string;

//https://leetcode.com/problems/reverse-words-in-a-string-ii/submissions/
public class ReverseWordsInStringII {
    public static void main(String[] args) {
        ReverseWordsInStringII reverse = new ReverseWordsInStringII();
        char[] arr = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverse.reverseWords(arr);
        System.out.println(arr);
    }

    public void reverseWords(char[] s) {
        reverseChars(s, 0, s.length - 1);
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseChars(s, left, i - 1);
                left = i + 1;
            }
        }
        reverseChars(s, left, s.length - 1);
    }

    private void reverseChars(char[] s, int start, int end) {
        if (start == end) return;
        for (int i = 0; i <  (end - start) / 2 + 1; i++) {
            char buff = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = buff;
        }
    }
}
