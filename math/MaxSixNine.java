package LeetCode.math;

public class MaxSixNine {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        MaxSixNine maxSixNine = new MaxSixNine();
        System.out.println(maxSixNine.maximum69Number(699));
    }
}
