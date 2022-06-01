package LeetCode.Intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/meeting-scheduler/
public class MeetingScheduler {

    //time cmplexity - O(mlog(m) + nlog(n))
    //space - constant
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int one = 0, two = 0;
        while (one < slots1.length && two < slots2.length) {
            int start = Math.max(slots1[one][0], slots2[two][0]);
            int end = Math.min(slots1[one][1], slots2[two][1]);
            if (end - start >= duration) return List.of(start, start + duration);
            else {
                if (end == slots1[one][1] && one + 1 < slots1.length) one++;
                else two++;
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = new MeetingScheduler();
        System.out.println(meetingScheduler.minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 8));
        System.out.println(meetingScheduler.minAvailableDuration(new int[][]{{0,1000000000}}, new int[][]{{0,1000000000}}, 1000000));
    }
}
