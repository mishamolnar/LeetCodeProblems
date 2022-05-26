package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//link - https://www.lintcode.com/problem/919/description
public class MeetingRoomsII {


    public int minMeetingRoomsTwo(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int curr = 0, max = 0, endPointer = 0;
        for (int i = 0; i < starts.length; i++) {
            curr++;
            while (starts[i] >= ends[endPointer]) {
                endPointer++;
                curr--;
            }
            max = Math.max(curr, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        List<MeetingRoomsII.Interval> list = new ArrayList<>();
//        list.add(new MeetingRoomsII.Interval(465, 497));
//        list.add(new MeetingRoomsII.Interval(386,462));
//        list.add(new MeetingRoomsII.Interval(354,380));
//        list.add(new MeetingRoomsII.Interval(134,189));
//        list.add(new MeetingRoomsII.Interval(199,282));
//        list.add(new MeetingRoomsII.Interval(18,109));
//        list.add(new MeetingRoomsII.Interval(499,562));
//        list.add(new MeetingRoomsII.Interval(4,14));
//        list.add(new MeetingRoomsII.Interval(111,129));
//        list.add(new MeetingRoomsII.Interval(292,345));    2
        //(65,424),(351,507),(314,807),(387,722),(19,797),(259,722),(165,221),(136,897)
        list.add(new MeetingRoomsII.Interval(65,424));
        list.add(new MeetingRoomsII.Interval(351,507));
        list.add(new MeetingRoomsII.Interval(314,807));
        list.add(new MeetingRoomsII.Interval(387,722));
        list.add(new MeetingRoomsII.Interval(19,797));
        list.add(new MeetingRoomsII.Interval(259,722));
        list.add(new MeetingRoomsII.Interval(165,221));
        list.add(new MeetingRoomsII.Interval(136,897));


//        list.add(new MeetingRoomsII.Interval(0,30));
//        list.add(new MeetingRoomsII.Interval(5,10));
//        list.add(new MeetingRoomsII.Interval(15,20));
        System.out.println(meetingRoomsII.minMeetingRooms(list));
    }

    //time - O(n log n)
    // space - O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int result = 0;
        for (int i = 0, j = 0; i < start.length; i++) {
            if (start[i] < end[j]) {
                result++;
            } else {
                j++;
            }
        }
        return result;
    }

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
