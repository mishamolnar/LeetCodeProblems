package LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        long epoch = 0;
        Map<Integer, Long> prevOne = new HashMap<>();
        for (int task : tasks) {
            epoch += Math.max(0, prevOne.getOrDefault(task, -10_0001L) + space - epoch);
            epoch++;
            prevOne.put(task, epoch);
        }
        return epoch;
    }

    public static void main(String[] args) {
        TaskSchedulerII taskSchedulerII = new TaskSchedulerII();
        System.out.println(taskSchedulerII.taskSchedulerII(new int[]{1,2,1,2,3,1}, 3));
    }
}
