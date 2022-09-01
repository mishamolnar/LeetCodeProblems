package LeetCode.math;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int max = -1, currMin = 11, min = 0, currMax = 0;
        for (int i = 1; i < sb.length(); i++) {
            int prev = sb.charAt(i - 1) - '1';
            int curr = sb.charAt(i) - '1';
            if (curr > prev) {
                min = i - 1;
                max = i;
                currMin = prev;
                currMax = curr;
            }
            if (curr > currMin && curr <= currMax) {
                currMax = curr;
                max = i;
            }
        }
        if (max == -1) return -1;
        swap(sb, min, max);
        int left = min + 1, right = sb.length() - 1;
        while (left < right) {
            swap(sb, left++, right--);
        }
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE)
            return -1;
        return Integer.parseInt(sb.toString());
    }

    private void swap(StringBuilder sb, int i, int j) {
        char buff = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, buff);
    }

    public static void main(String[] args) {
        NextGreaterElementIII nextGreaterElementIII = new NextGreaterElementIII();
        System.out.println(nextGreaterElementIII.nextGreaterElement(12));
    }
}
