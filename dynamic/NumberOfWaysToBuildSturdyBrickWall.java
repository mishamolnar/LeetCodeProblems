package LeetCode.dynamic;

import java.util.*;

//https://leetcode.com/problems/number-of-ways-to-build-sturdy-brick-wall/submissions/
public class NumberOfWaysToBuildSturdyBrickWall {
    static final int MOD = 1000000007;
    Integer[][] memo;


    public int buildWall(int height, int width, int[] bricks) {
        memo = new Integer[height][1024];
        List<List<Integer>> allPossible = new ArrayList<>();
        allPossible(width, bricks, 0, new ArrayList<>(), allPossible);
        HashMap<Integer, Set<Integer>> neighbors = allPossibleRows(allPossible, width);
        memo = new Integer[height][1024];
        if (height == 1) return allPossible.size();
        HashSet<Integer> initial = new HashSet<>();
        for (int i = 0; i < allPossible.size(); i++) initial.add(i);
        neighbors.put(-1, initial);
        return verticalDFS(0, -1, height, neighbors);
    }

    //O(height) * allPossible.size()
    private int verticalDFS(int currHeight, int curr, int height, HashMap<Integer, Set<Integer>> neighbors) {
        if (currHeight == height) return 1;
        if (curr > 0 && memo[currHeight][curr] != 0) return memo[currHeight][curr];
        int count = 0;

        for (Integer next : neighbors.get(curr)) {
            count = (count + verticalDFS(currHeight + 1, next, height, neighbors)) % MOD;
        }
        memo[currHeight][curr] = count;
        return count;
    }


    //bricks[].length * bricks[].length
    private HashMap<Integer, Set<Integer>> allPossibleRows(List<List<Integer>> allPossible, int width) {
        HashMap<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < allPossible.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < allPossible.size(); j++) {
                if ((neighbors.containsKey(j) && neighbors.get(j).contains(i))
                        || !intersects(allPossible.get(i), allPossible.get(j), width)) set.add(j);
            }
            neighbors.put(i, set);
        }
        return neighbors;
    }

    private boolean intersects(List<Integer> a, List<Integer> b, int width) {
        int i = a.get(0), j = b.get(0), pointer1 = 1, pointer2 = 1;
        while (i < width && j < width) {
            if (i == j) return true;
            if (i < j) i += a.get(pointer1++);
            else j += b.get(pointer2++);
        }
        return false;
    }

    //bricks[].length!
    private void allPossible(int width, int[] bricks, int curr, List<Integer> list, List<List<Integer>> result) {
        if (curr == width) {
            result.add(list);
        } else {
            for (int brick : bricks) {
                if (brick + curr > width) continue;
                list.add(brick);
                allPossible(width, bricks, curr + brick, new ArrayList<>(list), result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfWaysToBuildSturdyBrickWall numberOfWaysToBuildSturdyBrickWall = new NumberOfWaysToBuildSturdyBrickWall();
        List<List<Integer>> allPossible = new ArrayList<>();
        numberOfWaysToBuildSturdyBrickWall.allPossible(10, new int[]{2,3,4,5}, 0, new ArrayList<>(), allPossible);
        System.out.println(allPossible);
    }
}
