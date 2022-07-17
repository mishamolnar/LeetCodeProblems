package LeetCode.Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int res = 0, prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) {
                prevEnd = Math.min(prevEnd, interval[1]);
                res++;
            }
            else prevEnd = interval[1];
        }
        return res;
    }


    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}));
    }
}
