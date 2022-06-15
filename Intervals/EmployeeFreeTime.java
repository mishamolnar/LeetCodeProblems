package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/employee-free-time/discuss/195308/Java-PriorityQueue-Solution-Time-complexity-O(N-log-K)
public class EmployeeFreeTime {

    //nlogn time solution
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule.isEmpty()) return Collections.emptyList();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }
        int max = pq.poll().end;
        List<Interval> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (interval.start > max) result.add(new Interval(max, interval.start));
            max = Math.max(max, interval.end);
        }
        return result;
    }

    public List<Interval> employeeFreeTimeLogMy(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        //int[] 0 index - pointer in schedule, 1 index - pointer in employee
        for (int i = 0; i < schedule.size(); i++) pq.add(new int[]{i, 0});

        int max = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (schedule.get(curr[0]).get(curr[1]).start > max) {
                result.add(new Interval(max, schedule.get(curr[0]).get(curr[1]).start));
            }

            max = Math.max(max, schedule.get(curr[0]).get(curr[1]).end);
            if (schedule.get(curr[0]).size() > curr[1] + 1) pq.add(new int[]{curr[0], curr[1] + 1});
        }

        return result;
    }







    //Onlogk solution
    public List<Interval> employeeFreeTimeNlogK(List<List<Interval>> schedule) {
        //Create a priority queue with a comparator on the start of the first interval  in each list of intervals
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        //Populate the priority queue with the first interval from each list
        for (int i = 0; i < schedule.size(); i++) {
            //each element in the priority queue has 2 indexes. 0 points to the List on the List of schedules. 1 points to the index within the list selected by 0
            pq.add(new int[] {i, 0});
        }
        //Initialize the result arraylist
        List<Interval> res = new ArrayList<>();
        //set previous to the end of the first interval
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            //Get next interval from queue
            int[] index = pq.poll();
            Interval interval = schedule.get(index[0]).get(index[1]);
            if (interval.start > prev) {
                //No overlap, so add the gap in intervals
                res.add(new Interval(prev, interval.start));
            }
            prev = Math.max(prev, interval.end);
            if (schedule.get(index[0]).size() > index[1] + 1) {
                //Add the next interval into the priority queue, add the next element
                //from the  list whose interval was polled
                pq.add(new int[] {index[0], index[1] + 1});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EmployeeFreeTime freeTime = new EmployeeFreeTime();
        System.out.println(freeTime.employeeFreeTime(List.of(List.of(new Interval(1, 3), new Interval(6, 7)),
                List.of(new Interval(2, 4)),
                List.of(new Interval(2, 5), new Interval(9, 12)))));
    }

    // Definition for an Interval.
    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}
