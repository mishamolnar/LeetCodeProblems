package LeetCode.Intervals;

import java.util.Arrays;

// link - https://leetcode.com/problems/non-overlapping-intervals/submissions/
// complexity by time - O(n log n)
// space complexity - constant
public class EraseOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd <= intervals[i][0]) {
                prevEnd = intervals[i][1];
            } else {
                count++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
