package LeetCode.Intervals;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/amount-of-new-area-painted-each-day/
public class AmountOfNewAreaPaintedEachDay {

    //doesnt work
    public int[] amountPaintedTreeMap(int[][] paint) {
        int n = paint.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int[] current = paint[i];
            // start and end to record the merged interval
            int start = current[0];
            int end = current[1];
            int toPaint = end - start;

            Map.Entry<Integer, Integer> floor = intervals.floorEntry(current[0]);
            if (floor != null) {
                if (floor.getValue() >= end) {
                    // the entire current interval has been covered by floor, so the result[i] = 0 and simply just continue.
                    continue;
                }
                if (floor.getValue() >= start) {
                    // the current interval has been partially covered by floor, so deduct the overlapping length.
                    toPaint -= floor.getValue() - start;
                    intervals.remove(floor.getKey());
                    start = floor.getKey();
                }
            }

            Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(current[0]);
            // there could be multiple ceilings overlap with the current interval.
            // e.g. current [5, 20], ceilings: [6, 8], [10, 15], [18, 22]
            // We need to deduct the overlapping length properly
            while (ceiling != null && ceiling.getKey() <= end) {
                toPaint -= Math.min(end, ceiling.getValue()) - ceiling.getKey();
                intervals.remove(ceiling.getKey());
                end = Math.max(end, ceiling.getValue());
                ceiling = intervals.ceilingEntry(current[0]);
            }

            result[i] = toPaint;
            // add the merged interval to treemap
            intervals.put(start, end);
        }

        return result;
    }

    //Time n + 10000
    public int[] amountPainted(int[][] paint) {
        int[] arr = new int[100000];
        int[] result = new int[paint.length];
        for (int p = 0; p < paint.length; p++) {
            for (int i = paint[p][0]; i < paint[p][1]; i++) {
                if (arr[i] == 0) {
                    arr[i] = paint[p][1];
                    result[p]++;
                } else i = arr[i] - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AmountOfNewAreaPaintedEachDay amount = new AmountOfNewAreaPaintedEachDay();
        System.out.println(Arrays.toString(amount.amountPaintedTreeMap(new int[][]{{1, 4}, {5, 8}, {4, 7}})));
    }
}
