package LeetCode.arrays;

import java.awt.desktop.PreferencesEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin closestPointsToOrigin = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(closestPointsToOrigin.kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
    }


    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int p = quickSelect(points, left, right);
            if (p == k) break;
            if (p < k) left = p + 1;
            else right = p - 1;
        }
        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int quickSelect(int[][] points, int left, int right) {
        int[] pivot = points[right];
        for (int i = left; i < right; i++) {
            if (compare(points[i], pivot) <= 0) {
                swap(points, i, left);
                left++;
            }
        }
        swap(points, left, right);
        return left;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] buff = points[i];
        points[i] = points[j];
        points[j] = buff;
    }

    public int[][] kClosestPQ(int[][] points, int k) {
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
