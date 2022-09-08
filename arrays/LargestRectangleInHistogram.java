package LeetCode.arrays;

//https://leetcode.com/problems/largest-rectangle-in-histogram
public class LargestRectangleInHistogram {


    public int largestRectangleAreaII(int[] heights) {
        int len = heights.length;
        int[] lessLeft = new int[len];
        for (int i = 0; i < len; i++) {
            int nextLess = i - 1;
            while (nextLess >= 0 && heights[nextLess] >= heights[i])
                nextLess = lessLeft[nextLess];
            lessLeft[i] = nextLess;
        }

        int[] lessRight = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int nextLess = i + 1;
            while (nextLess < len && heights[nextLess] >= heights[i])
                nextLess = lessRight[nextLess];
            lessRight[i] = nextLess;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (lessRight[i] - lessLeft[i] - 1) * heights[i]);
        }
        return res;
    }


    public int largestRectangleArea(int[] heights) {
        int[] lessLeft = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessLeft[p];
            }
            lessLeft[i] = p;
        }

        int[] lessRight = new int[heights.length];;
        for (int i = heights.length - 1; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]){
                p = lessRight[p];
            }
            lessRight[i] = p;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (lessRight[i] - lessLeft[i] - 1) * heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
        System.out.println(histogram.largestRectangleAreaII(new int[]{2,1,2}));
    }
}
