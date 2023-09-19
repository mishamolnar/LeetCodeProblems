package LeetCode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //create map size -> group
        //iterate and add each person to the group
        //if group size is arr[i] then add it to the answer and remove from map
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(map.get(groupSizes[i]));
                res.remove(groupSizes[i]);
            }
        }
        return res;
    }
}
