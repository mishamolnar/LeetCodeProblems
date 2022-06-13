package LeetCode.Intervals;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
public class MeetingRoomsLeetCode {

    public boolean canAttendMeetingsSorting(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] == intervals[i + 1][0]
            || intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }

    //O(n) time and space
    public boolean canAttendMeetings(int[][] intervals) {
        short[] arr = new short[1000001]; //start - 1 end 2
        for (int[] interval : intervals) {
            arr[interval[0]]--;
            arr[interval[1]]++;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < -1) return false;
        }
        return true;
    }
}
