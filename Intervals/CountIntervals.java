package LeetCode.Intervals;

import java.util.TreeMap;

//https://leetcode.com/problems/count-integers-in-intervals/description/
public class CountIntervals {
    TreeMap<Integer, Integer> map;
    int total;

    public CountIntervals() {
        map = new TreeMap<>();
        total = 0;
    }

    public void add(int left, int right) {
        while (map.floorEntry(right) != null && map.floorEntry(right).getValue() >= left) {
            var fl = map.floorEntry(right);
            total -= (fl.getValue() - fl.getKey() + 1);
            right = Math.max(right, fl.getValue());
            left = Math.min(left, fl.getKey());
            map.remove(fl.getKey());
        }
        map.put(left, right);
        total += (right - left + 1);
    }

    public int count() {
        return total;
    }
}
