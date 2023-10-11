package LeetCode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class NumberOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Map<Integer,  List<Integer>> timeToPeople = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            timeToPeople.putIfAbsent(people[i], new ArrayList<>());
            timeToPeople.get(people[i]).add(i);
        }
        int n = people.length;
        people = IntStream.of(people).distinct().toArray();
        Arrays.sort(people);
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        for (int[] flower : flowers) {
            start.add(flower[0]);
            end.add(flower[1]);
        }
        int[] res = new int[n];
        int count = 0;
        for (int time : people) {
            while (!start.isEmpty() && start.peek() <= time) {
                count++;
                start.poll();
            }
            while (!end.isEmpty() && end.peek() < time) {
                count--;
                end.poll();
            }
            for (Integer person : timeToPeople.get(time)) {
                res[person] = count;
            }
        }
        return res;
    }
}
