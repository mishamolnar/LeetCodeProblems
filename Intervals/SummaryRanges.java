package LeetCode.Intervals;

import java.util.Map;
import java.util.TreeMap;

class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
         this.map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        var floor = map.floorEntry(value);
        if (floor != null && floor.getValue() >= value) {
            return;
        } else if (floor != null && floor.getValue() + 1 == value) {
            map.put(floor.getKey(), value);
        } else {
            map.put(value, value);
        }
        var ceil = map.ceilingEntry(value + 1);
        floor = map.floorEntry(value);
        if (ceil != null && ceil.getKey() == value + 1) {
            map.remove(ceil.getKey());
            map.put(floor.getKey(), ceil.getValue());
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int iterator = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            res[iterator][0] = integerIntegerEntry.getKey();
            res[iterator][1] = integerIntegerEntry.getValue();
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */