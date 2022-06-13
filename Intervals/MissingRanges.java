package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

    //https://leetcode.com/problems/missing-ranges/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = i < nums.length ? nums[i] : upper;
            if (prev + 1 < curr) result.add(formatRange(prev + 1, curr - 1));
            prev = curr;
        }
        return result;
    }

    private String formatRange(int start, int end) {
        if (start == end) return String.valueOf(start);
        return start + "->" + end;
    }

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        System.out.println(missingRanges.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
    }
}
