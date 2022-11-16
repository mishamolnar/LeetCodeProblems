package LeetCode.dynamic;

public class FlipToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - '0';
        int res = s.length() - sum, currSum = 0, len = s.length();
        for (int i = 0; i < s.length(); i++) {
            currSum += s.charAt(i) - '0';
            res = Math.min(res, Math.max(currSum, (len - i - 1) - (sum - currSum)));
        }
        return res;
    }

    public static void main(String[] args) {
        FlipToMonotoneIncreasing flipToMonotoneIncreasing = new FlipToMonotoneIncreasing();
        System.out.println(flipToMonotoneIncreasing.minFlipsMonoIncr("010110"));
    }
}
