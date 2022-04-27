package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//link - https://leetcode.com/problems/insert-interval/submissions/
// time and space complexity - O(n)
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int[][] result = new int[intervals.length + 1][];
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[i] = intervals[i];
            i++;
        }
        int pointer = i;
        while (pointer < intervals.length && newInterval[1] >= intervals[pointer][0]) {
            int start = newInterval[0];
            int end = newInterval[1];
            newInterval = new int[]{Math.min(start, intervals[pointer][0]), Math.max(end, intervals[pointer][1])};
            pointer++;
        }
        result[i] = newInterval;
        i++;
        while (pointer < intervals.length) {
            result[i] = intervals[pointer];
            pointer++;
            i++;
        }
        int[][] output = new int[i][];
        System.arraycopy(result, 0, output, 0, i);
        return output;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(new int[][]{{1,5}}, new int[]{6,8});
        System.out.println(Arrays.deepToString(result));
    }

    // wil cause very messy solution + array coping, this method doesn't make sense
    public int[][] insertWithBinarySearch(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length -1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (intervals[mid][0] < newInterval[0]) {
                start = mid + 1;
            } else end = mid;
        }
        while (intervals[end][1] < newInterval[1]) {
            end++;
        }
        if (intervals[start - 1][1] >= newInterval[0]) {
            start = start - 1;
        }
        if (intervals[end][0] > newInterval[2]) {
            end = end - 1;
        }
        System.out.println("start " + start);
        System.out.println("end" + end);
        return intervals;
    }
}
