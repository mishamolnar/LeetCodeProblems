package LeetCode.sorting;

import java.util.Objects;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        // 1 pq - to mainain currently available, sorted by a enque time, another - with time and index
        PriorityQueue<Integer> futures = new PriorityQueue<>((a, b) -> Integer.compare(tasks[a][0], tasks[b][0]));
        PriorityQueue<int[]> current = new PriorityQueue<>((a, b) -> !Objects.equals(a[0], b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])); //0 - time, 1 - index
        for (int i = 0; i < tasks.length; i++) futures.add(i);
        int order = 0, time = 0;
        while (!current.isEmpty() || !futures.isEmpty()) {
            if (current.isEmpty() && time < tasks[futures.peek()][0]) {
                time = tasks[futures.peek()][0];
            }
            while (!futures.isEmpty() && time >= tasks[futures.peek()][0]) {
                current.add(new int[]{tasks[futures.peek()][1], futures.poll()});
            }
            res[order++] = current.peek()[1];
            time += tasks[current.poll()[1]][1];
        }
        return res;
    }

}
