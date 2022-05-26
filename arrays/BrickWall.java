package LeetCode.arrays;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public static void main(String[] args) {
        BrickWall brickWall = new BrickWall();
        System.out.println(brickWall.leastBricks(List.of(List.of(1,2,21), List.of(3,1,2), List.of(1,3,2), List.of(2,4), List.of(3,1,2), List.of(1,3,1,1))));
    }

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (List<Integer> row : wall) {
            int curr = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                curr += row.get(i);
                int buff = count.getOrDefault(curr, 0) + 1;
                max = Math.max(buff, max);
                count.put(curr, buff);
            }
        }
        return wall.size() - max;
    }
}
