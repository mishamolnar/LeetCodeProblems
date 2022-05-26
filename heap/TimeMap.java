package LeetCode.heap;

import java.util.HashMap;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/
public class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map= new HashMap<>();
    }

    //log n complexity
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }
    }

    //log(n)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        if (map.get(key).floorEntry(timestamp) == null) return "";
        return map.get(key).floorEntry(timestamp).getValue();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
        System.out.println(timeMap.get("foo", -1));
    }
}
