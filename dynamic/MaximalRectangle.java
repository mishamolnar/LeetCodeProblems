package LeetCode.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int res  = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0')
                    heights[i] = 0;
                else heights[i]++;
            }
            res = Math.max(res, maxRectangle(heights));
        }
        return res;
    }

    private int maxRectangle(int[] heights) {
        int[] lessLeft = new int[heights.length];
        for (int i = 0; i < lessLeft.length; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i])
                left = lessLeft[left];
            lessLeft[i] = left;
        }

        int[] lessRight = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int right = i + 1;
            while (right < heights.length && heights[right] >= heights[i])
                right = lessRight[right];
            lessRight[i] = right;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (lessRight[i] - lessLeft[i] - 1) * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'1','0'},{'0','1'}}));
    }
}
