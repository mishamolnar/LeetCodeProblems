package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ErectTheFence {
    public int[][] outerTrees(int[][] trees) {
        Point[] arr = new Point[trees.length];
        for (int i = 0; i < trees.length; i++) {
            arr[i] = new Point(trees[i][0], trees[i][1]);
        }
        var res = outerTrees(arr);
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[]{res.get(i).x, res.get(i).y};
        }
        return ans;
    }

    private  class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 1)
            return Arrays.asList(points);
        sortByPolar(points, bottomLeft(points));
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < points.length; i++) {
            Point top = stack.pop();
            while (ccw(stack.peek(), top, points[i]) < 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points[i]);
        }
        return new ArrayList<>(stack);
    }

    private static Point bottomLeft(Point[] points) {
        Point bottomLeft = points[0];
        for (Point p : points)
            if (p.y < bottomLeft.y || p.y == bottomLeft.y && p.x < bottomLeft.x)
                bottomLeft = p;
        return bottomLeft;
    }

    /**
     * @return positive if counter-clockwise, negative if clockwise, 0 if collinear
     */
    private static int ccw(Point a, Point b, Point c) {
        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
    }

    /**
     * @return distance square of |p - q|
     */
    private static int dist(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    private static void sortByPolar(Point[] points, Point r) {
        Arrays.sort(points, (p, q) -> {
            int compPolar = ccw(p, r, q);
            int compDist = dist(p, r) - dist(q, r);
            return compPolar == 0 ? compDist : compPolar;
        });
        // find collinear points in the end positions
        Point p = points[0], q = points[points.length - 1];
        int i = points.length - 2;
        while (i >= 0 && ccw(p, q, points[i]) == 0)
            i--;
        // reverse sort order of collinear points in the end positions
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point tmp = points[l];
            points[l] = points[h];
            points[h] = tmp;
        }
    }
}
