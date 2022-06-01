package LeetCode.string;

import java.util.*;
import java.util.stream.Collectors;


//https://leetcode.com/problems/design-log-storage-system/solution/
public class LogSystem {
    TreeMap<String, List<Integer>> treeMap;
    Map<String, Integer> formatting = Map.of("Year", 5, "Month", 8, "Day", 11, "Hour", 14, "Minute", 17, "Second", 19);

    public LogSystem() {
        treeMap = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        treeMap.putIfAbsent(timestamp, new ArrayList<>());
        treeMap.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        if (granularity.equals("Second")) return treeMap.subMap(start, true, end, true).values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        start = start.substring(0, this.formatting.get(granularity)) + "/";
        end = end.substring(0, this.formatting.get(granularity)) + "?";
        return treeMap.subMap(start, true, end, true).values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        logSystem.put(4, "2016:01:01:00:00:00");

        // return [3,2,1], because you need to return all logs between 2016 and 2017.
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));

        // return [2,1], because you need to return all logs between Jan. 1, 2016 01:XX:XX and Jan. 1, 2017 23:XX:XX.
        // Log 3 is not returned because Jan. 1, 2016 00:00:00 comes before the start of the range.
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }



    //    TreeMap < Long, Integer > map;
    //    public LogSystem() {
    //        map = new TreeMap < Long, Integer > ();
    //    }
    //
    //    public void put(int id, String timestamp) {
    //        int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
    //        map.put(convert(st), id);
    //    }
    //    public long convert(int[] st) {
    //        st[1] = st[1] - (st[1] == 0 ? 0 : 1);
    //        st[2] = st[2] - (st[2] == 0 ? 0 : 1);
    //        return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60 + st[3] * 60 * 60 + st[4] * 60 + st[5];
    //    }
    //    public List < Integer > retrieve(String s, String e, String gra) {
    //        ArrayList < Integer > res = new ArrayList();
    //        long start = granularity(s, gra, false);
    //        long end = granularity(e, gra, true);
    //        for (long key: map.tailMap(start).keySet()) {
    //            if (key >= start && key < end)
    //                res.add(map.get(key));
    //        }
    //        return res;
    //    }
    //
    //    public long granularity(String s, String gra, boolean end) {
    //        HashMap < String, Integer > h = new HashMap();
    //        h.put("Year", 0);
    //        h.put("Month", 1);
    //        h.put("Day", 2);
    //        h.put("Hour", 3);
    //        h.put("Minute", 4);
    //        h.put("Second", 5);
    //        String[] res = new String[] {"1999", "00", "00", "00", "00", "00"};
    //        String[] st = s.split(":");
    //        for (int i = 0; i <= h.get(gra); i++) {
    //            res[i] = st[i];
    //        }
    //        int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
    //        if (end)
    //            t[h.get(gra)]++;
    //        return convert(t);
    //
}
