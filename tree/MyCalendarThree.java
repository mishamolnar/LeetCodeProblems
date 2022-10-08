package LeetCode.tree;

import java.util.TreeMap;

public class MyCalendarThree {
    private TreeMap<Integer, Integer> map;
    private int max = 0;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        var prev = map.floorEntry(start);
        map.put(start, prev == null ? 1 : prev.getValue() + 1);
        max = Math.max(max, map.get(start));
        var next = map.ceilingEntry(start + 1);
        while (next != null && next.getKey() < end) {
            map.put(next.getKey(), next.getValue() + 1);
            max = Math.max(max, next.getValue() + 1);
            next = map.ceilingEntry(next.getKey() + 1);
        }
        if (next == null || next.getKey() > end) {
            prev = map.floorEntry(end);
            map.put(end, prev.getValue() - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(27,36);
        myCalendarThree.book(20,27);
        myCalendarThree.book(15,23);
        myCalendarThree.book(27,36);
        myCalendarThree.book(17,25);
        myCalendarThree.book(24,33);
        System.out.println(myCalendarThree.book(23,28));
        System.out.println(myCalendarThree.book(21,27));
    }
}
