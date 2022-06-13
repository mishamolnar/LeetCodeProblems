package LeetCode.arrays;

import java.util.*;

//https://leetcode.com/problems/high-five/
public class HighFive {

    //O(nlogn) time and O(n) space
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> hashMap = new TreeMap<>();
        for (int[] item : items) {
            hashMap.putIfAbsent(item[0], new PriorityQueue<>());
            hashMap.get(item[0]).add(item[1]);
            if (hashMap.get(item[0]).size() > 5) hashMap.get(item[0]).poll();
        }
        int[][] result = new int[hashMap.size()][];
        int pointer = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hashMap.entrySet()) {
            result[pointer] = new int[2];
            result[pointer][0] = entry.getKey();
            result[pointer++][1] = entry.getValue().stream().reduce(0, Integer::sum) / 5;
        }
        return result;
    }

    public static void main(String[] args) {
        HighFive highFive = new HighFive();
        System.out.println(Arrays.deepToString(highFive.highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}})));
    }
}
