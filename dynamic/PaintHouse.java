package LeetCode.dynamic;

//https://leetcode.com/problems/paint-house/solution/
public class PaintHouse {

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}}));
    }

    // O(n) time and constant space
    // O(n) because for each cell we are doing only 3 jperations
    // if we would have m colors - then complexity will be O(n * m)
    public int minCost(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            for (int j = 0; j < costs[0].length; j++) {
                int prevPrice = 0;
                if (j == 0) prevPrice = Math.min(costs[i + 1][1], costs[i + 1][2]);
                else if (j == 2) prevPrice = Math.min(costs[i + 1][0], costs[i + 1][1]);
                else prevPrice = Math.min(costs[i + 1][0], costs[i + 1][2]);
                costs[i][j] += prevPrice;
            }
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
