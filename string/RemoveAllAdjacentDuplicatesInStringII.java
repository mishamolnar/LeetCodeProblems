package LeetCode.string;

import java.util.Arrays;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII remove = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(Arrays.toString(remove.extend(new StringBuilder("dddbbccccbbdaa"), 5, 8, 3)));
        System.out.println(remove.removeDuplicates("ghanyhhhhhttttttthhyyyyyynnnnnnyqkkkkkkkrrrrrrjjjjjjjryyyyyyfffffffygq", 7));
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count = 1;
        char curr = sb.charAt(0);
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == curr) count++;
            else count = 1;
            curr = sb.charAt(i);
            if (count == k) {
                int[] arr = extend(sb, (i - k + 1), i, k);
                sb.replace(arr[0], arr[1] + 1, "");
                i = Math.max(arr[0] - 2, -1);
            }
        }
        return sb.toString();
    }

    private int[] extend(StringBuilder sb, int left, int right, int k) {
        if (left - right + 1 == sb.length()) return new int[] {left, right};
        int leftR = left, rightR = right;
        while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
            if ((right - left + 1) % k == 0) {
                rightR = right++;
                leftR = left--;
            }
            if (left <= 0 || right >= sb.length() - 1) break;
            if (sb.charAt(left - 1) == sb.charAt(right + 1) && sb.charAt(left - 1) == sb.charAt(left)) {
                left--;
                right++;
            } else if (sb.charAt(left - 1) == sb.charAt(right)) {
                left--;
            } else right++;
        }
        return new int[]{leftR, rightR};
    }
}
