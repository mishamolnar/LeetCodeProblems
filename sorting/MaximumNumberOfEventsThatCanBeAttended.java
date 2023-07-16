package LeetCode.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    //algo:
    //iterate over the days and maintain open meetings
    //pick the meeting with the soonest deadline
    //each day we:
    //add the meetings that end now to the priorityQueue
    //remove meetings that ended already
    //increment and poll if queue is not empty
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> endDays = new PriorityQueue<>();
        int res = 0, event = 0;
        for (int currDay = 1; currDay < 1_00_000; currDay++) {
            while (event < events.length && events[event][0] == currDay)
                endDays.add(events[event++][1]);
            while (!endDays.isEmpty() && endDays.peek() < currDay)
                endDays.poll();
            if (!endDays.isEmpty()) {
                endDays.poll();
                res++;
            }
        }
        return res;
    }
}
