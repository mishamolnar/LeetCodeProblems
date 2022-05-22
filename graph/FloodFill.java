package LeetCode.graph;


//link - https://leetcode.com/problems/flood-fill/submissions/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        if (prevColor == newColor) return image;
        dfs(image, prevColor, newColor, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int prevColor, int newColor, int x, int y) {
        image[x][y] = newColor;
        if (x > 0 && image[x - 1][y] == prevColor) dfs(image, prevColor, newColor, x - 1, y);
        if (y > 0 && image[x][y - 1] == prevColor) dfs(image, prevColor, newColor, x, y - 1);
        if (x < image.length - 1 && image[x + 1][y] == prevColor) dfs(image, prevColor, newColor, x + 1, y);
        if (y < image[0].length - 1 && image[x][y + 1] == prevColor) dfs(image, prevColor, newColor, x, y + 1);
    }
}
