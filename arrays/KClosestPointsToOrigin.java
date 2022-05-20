package LeetCode.arrays;

import java.awt.desktop.PreferencesEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin closestPointsToOrigin = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(closestPointsToOrigin.kClosest(new int[][]{{3, 3,}, {5, -1}, {-2, 4}}, 2)));
    }

    public int[][] kClosest(int[][] points, int k) {
        ArrayList<Point> arr = new ArrayList<>();
        for (int[] point : points) arr.add(new Point(point));
        PriorityQueue<Point> pq = new PriorityQueue<>(arr);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = new int[]{pq.peek().x, pq.poll().y};
        }
        return res;
    }


    private class Point implements Comparable{
        private int x;
        private int y;

        public Point(int[] arr) {
            this.x = arr[0];
            this.y = arr[1];
        }

        @Override
        public int compareTo(Object o) {
            Point o1 = (Point) o;
            return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)) - Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2)) < 0 ? -1 : 1;
        }
    }
}
