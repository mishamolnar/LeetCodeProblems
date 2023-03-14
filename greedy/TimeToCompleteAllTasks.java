package LeetCode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeToCompleteAllTasks {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[1], b[1]));
        boolean[] used = new boolean[2001];
        for (int[] task : tasks) {
            for (int i = task[0]; i <= task[1]; i++) {
                task[2] -= used[i] ? 1 : 0;
            }
            int time = task[1];
            while (task[2] > 0) {
                if (!used[time]) {
                    used[time] = true;
                    task[2]--;
                }
                time--;
            }
        }
        int res = 0;
        for (boolean using : used) {
            res += using ? 1 : 0;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new TimeToCompleteAllTasks().findMinimumTime(new int[][]{{1, 18, 5}, {3, 15, 1}}));
    }
}
