package LeetCode.design;

import java.util.*;

//https://leetcode.com/problems/lfu-cache/
public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;//count - queue with all numbers that have this count
    int cap;
    int minFreq = 1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }


    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        incrementCount(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (vals.containsKey(key)) {
            vals.put(key, value);
            incrementCount(key);
        } else {
            vals.put(key, value);
            counts.put(key, 1);
            lists.get(1).add(key);
            if (cap < vals.size()) {
                int toRemove = lists.get(minFreq).iterator().next();
                lists.get(minFreq).remove(toRemove);
                vals.remove(toRemove);
                counts.remove(toRemove);
            }
            minFreq = 1;
        }
    }

    private void incrementCount(int key) {
        int curr = counts.get(key);
        counts.put(key, curr + 1);
        lists.get(curr).remove(key);
        lists.putIfAbsent(curr + 1, new LinkedHashSet<>());
        lists.get(curr + 1).add(key);
        if (curr == minFreq && lists.get(curr).isEmpty()) minFreq++;
    }


    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
