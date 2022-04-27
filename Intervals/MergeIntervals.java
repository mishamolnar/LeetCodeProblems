package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// complexity - O(n log n) time and O(n) space
// link - https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(new int[][]{{1,4},{4,5}});
        System.out.println(Arrays.deepToString(result));
    }
}
