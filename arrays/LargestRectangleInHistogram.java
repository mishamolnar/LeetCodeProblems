package LeetCode.arrays;

//https://leetcode.com/problems/largest-rectangle-in-histogram
public class LargestRectangleInHistogram {


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
        System.out.println(histogram.largestRectangleArea(new int[]{2,1,3,4,1,4,1,3}));
    }
}
