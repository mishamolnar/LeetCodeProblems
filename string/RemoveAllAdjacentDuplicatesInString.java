package LeetCode.string;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString remove = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(remove.removeDuplicates("abbacaazxxzy"));
    }

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                int j = extend(sb, i - 1, i) - 1;
                sb.replace(i - 1 - j, i + j + 1, "");
                i -= (j + 1);
            }
        }
        return sb.toString();
    }

    private int extend(StringBuilder s, int left, int right) {
        int i = 0;
        while (left - i >= 0 && right + i < s.length() && s.charAt(left - i) == s.charAt(right + i)) i++;
        return i;
    }
}
