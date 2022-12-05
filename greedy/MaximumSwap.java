package LeetCode.greedy;

public class MaximumSwap {
    public int maximumSwap(int num) {
        //7654321
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int right = sb.length() - 1, left = -1;
        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) <= sb.charAt(right)) {
                left = i;
            } else if (sb.charAt(i) > sb.charAt(right)) {
                right = i;
            }
        }
        if (left == -1) return num;
        char buff = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, buff);
        return Integer.parseInt(sb.toString());
    }
}
