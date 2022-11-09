package LeetCode.dynamic;

import java.util.Arrays;

public class MinimumTicketCost {
    public int mincostTickets(int[] days, int[] costs) {
        int[] total = new int[356];
        Arrays.fill(total, Integer.MAX_VALUE);
        total[days[0]] = 0;
        for (int day : days) {
            normalize(costs, day, day + 1, total[day] + costs[0]);
            normalize(costs, day, day + 7, total[day] + costs[1]);
            normalize(costs, day, day + 365, total[day] + costs[2]);
        }
        return total[days[days.length - 1]];
    }


    private void normalize(int[] costs, int start, int end, int price) {
        for (int i = start; i < Math.min(end, 365); i++) {
            costs[i] = Math.min(costs[i], price);
        }
    }
}
