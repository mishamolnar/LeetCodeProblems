package LeetCode.heap;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {

    //O(n) time and constant space
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) max = Math.max(max, ++counts[task - 'A']);
        for (int count : counts) if (count == max) maxCount++;

        int spacesCount = max - 1;
        int spacesLength = n - (maxCount - 1);
        int emptySlots = spacesCount * spacesLength;
        int tasksToSet = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - tasksToSet);

        return tasks.length + idles;
    }

    //nlogn time and O(n) space
    public int leastIntervalNotOptimal(char[] tasks, int n) {
        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> onCoolDown = new ArrayDeque<>(); //0 - time when cool down ends, 1 - int
        int[] chars = new int[26];
        for (char task : tasks) chars[task - 'A']++;
        int time = 0;
        for (int aChar : chars) if (aChar > 0) available.add(aChar);
        while (!available.isEmpty() || !onCoolDown.isEmpty()) {
            while (!onCoolDown.isEmpty() && onCoolDown.peek()[0] <= time)
                available.add(onCoolDown.poll()[1]);
            if (!available.isEmpty()) {
                if (available.peek() == 1) available.poll();
                else onCoolDown.add(new int[]{time + n + 1, available.poll() - 1});
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
