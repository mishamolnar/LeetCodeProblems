package LeetCode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {

    }

    //prims algo
    // O(n) space
    // O(n2) time
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> mst = new HashSet<>();
        mst.add(0); //починаємо з нульового елементу
        int[] shortestDistances = new int[points.length];
        for (int i = 1; i < shortestDistances.length; i++) {
            shortestDistances[i] = findDistance(points, 0, i); //обчислюємо найкоротші шляхи для нульового елементу
        }
        int result = 0;

        while (mst.size() != points.length) {
            int next = -1;
            for (int i = 0; i < points.length; i++) {
                if (mst.contains(i)) continue;
                if (next == -1 || shortestDistances[next] > shortestDistances[i]) next = i; // просто шукаємо мінімальний шлях до наступного вільного елементу
            }

            mst.add(next); // додаємо цю точку в minimum spanning tree
            result += shortestDistances[next]; //додаємо цей шлях

            for (int i = 0; i < points.length; i++) {
                if (mst.contains(i)) continue;
                shortestDistances[i] = Math.min(shortestDistances[i], findDistance(points, i, next)); //обчислюємо відстань до новододаного елементу і якщо вона менша від попередньої -0 обновляємо
            }
        }
        return result;
    }

    private int findDistance(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
