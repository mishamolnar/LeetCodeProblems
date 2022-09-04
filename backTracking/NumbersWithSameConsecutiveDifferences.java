package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/numbers-with-same-consecutive-differences/solution/
public class NumbersWithSameConsecutiveDifferences {

    //worst case 2^N
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            backtrack(res, i, n, k);
        return Arrays.stream(res.toArray()).mapToInt(a -> (int) a).toArray();
    }

    private void backtrack(List<Integer> res, int curr, int n, int k) {
        if (curr >= Math.pow(10, n - 1)) {
            res.add(curr);
        } else {
            if (curr % 10 + k < 10)
                backtrack(res, curr * 10 + curr % 10 + k, n, k);
            if (curr % 10 - k >= 0)
                backtrack(res, curr * 10 + curr % 10 - k, n, k);
        }
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences number = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(number.numsSameConsecDiff(3, 7)));
    }
}
