package LeetCode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-original-array-from-doubled-array/
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, int[]> map = new HashMap<>(); //0 - curr, 1 - max
        for (int num : changed) {
            if (num % 2 == 0 && map.getOrDefault(num / 2, new int[]{0, 0})[0] > 0) {
                map.get(num / 2)[0]--;
            } else {
                int[] curr = map.getOrDefault(num, new int[]{0, 0});
                curr[0]++;
                curr[1]++;
                map.put(num, curr);
            }
        }
        List<Integer> arr = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] == 0) {
                for (int i = 0; i < entry.getValue()[1]; i++) {
                    arr.add(entry.getKey());
                }
            }
            else return new int[0];
        }
        return arr.stream().mapToInt(a -> (int) a).toArray();
    }


}
