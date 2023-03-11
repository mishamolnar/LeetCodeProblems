package LeetCode.binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class AvoidFlood {
    public int[] avoidFlood(int[] rains) {
        //queue + set, queue for memorizing available days, set for memorizing full lakes
        TreeSet<Integer> available = new TreeSet<>();
        Map<Integer, Integer> history = new HashMap<>();
        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (history.containsKey(rains[i])) {
                    Integer indexOfDryDay = available.ceiling(history.get(rains[i]));
                    if (indexOfDryDay == null) {
                        return new int[0];
                    } else {
                        ans[indexOfDryDay] = rains[i];
                        available.remove(indexOfDryDay);
                    }
                }
                history.put(rains[i], i);
                ans[i] = -1;
            } else {
                available.add(i);
            }
        }
        for (Integer integer : available)
            ans[integer] = 1;
        return ans;
    }
}