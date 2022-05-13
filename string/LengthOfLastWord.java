package LeetCode.string;

//link -- https://leetcode.com/problems/length-of-last-word/submissions/
public class LengthOfLastWord {

    // O(n) time, where n - length of space and word, constant space
    public int lengthOfLastWord(String s) {
        int pointer = s.length() - 1;
        while (pointer >= 0 && s.charAt(pointer) == ' ') pointer--;
        int count = 0;
        while (pointer >= 0 && !(s.charAt(pointer) == ' ')) {
            count++;
            pointer--;
        }
        return count;
    }
}
