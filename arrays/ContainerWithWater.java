package LeetCode.arrays;

//link - https://leetcode.com/problems/container-with-most-water/
public class ContainerWithWater {

    // time - O(n) space - O(1)
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1; int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right])); //rectangle area calculation
            if (height[left] > height[right]) right--; // shift right if it is lower
            else if (height[left] < height[right]) left++; // shift left if it is lower
            else { //if same
                if (height[left + 1] > height[right - 1]) left++; //shift left if next left is higher
                else right--;
            }
        }
        return max; // return max area
    }

    public static void main(String[] args) {
        ContainerWithWater containerWithWater = new ContainerWithWater();
        System.out.println(containerWithWater.maxArea(new int[]{2,1}));
    }
}
