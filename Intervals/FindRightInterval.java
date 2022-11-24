package LeetCode.Intervals;

import java.util.TreeMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            var buff = map.ceilingEntry(intervals[i][1]);
            res[i] = buff == null? -1 : buff.getValue();
        }
        return res;
    }
}
