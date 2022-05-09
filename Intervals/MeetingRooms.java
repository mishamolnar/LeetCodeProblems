package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//link - https://www.lintcode.com/problem/920/
public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(465, 497));
        list.add(new Interval(386,462));
        list.add(new Interval(354,380));
        list.add(new Interval(134,189));
        list.add(new Interval(199,282));
        list.add(new Interval(18,104));
        list.add(new Interval(499,562));
        list.add(new Interval(4,14));
        list.add(new Interval(111,129));
        list.add(new Interval(292,345));
        System.out.println(meetingRooms.canAttendMeetings(list));//true
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
        }
        return true;
    }

    private static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }
}
