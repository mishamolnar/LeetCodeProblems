package LeetCode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/buildings-with-an-ocean-view/
public class BuildingsWithOceanView {

    public static void main(String[] args) {
        BuildingsWithOceanView buildings = new BuildingsWithOceanView();
        System.out.println(Arrays.toString(buildings.findBuildings(new int[]{4, 2, 3, 1})));
    }

    //linear time and constant space
    public int[] findBuildings(int[] heights) {
        int pointer = heights.length - 1, max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                heights[pointer--] = i;
            }
        }
        int[] result = new int[heights.length - 1 - pointer];
        System.arraycopy(heights, pointer + 1, result, 0, result.length );
        return result;
    }
}
