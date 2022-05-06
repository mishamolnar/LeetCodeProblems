package LeetCode.graph;

import java.util.List;

// link - https://leetcode.com/problems/keys-and-rooms/
// O(m) space - O(n)
public class KeysAndRooms {
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] marked = new boolean[rooms.size()];
        DFS(0, marked, rooms);
        for (boolean b : marked) if (!b) return b;
        return true;
    }

    private void DFS(int current, boolean[] marked, List<List<Integer>> rooms) {
        if (marked[current]) return;
        marked[current] = true;
        for (Integer i : rooms.get(current)) {
            DFS(i, marked, rooms);
        }
    }
}
