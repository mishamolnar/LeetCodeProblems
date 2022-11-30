package LeetCode.backTracking;

public class TilingRectangleWithTheFewestSquares {
    public int tilingRectangle(int n, int m) {
        return dfs(new boolean[n][m], 0, 0);
    }

    private int dfs(boolean[][] rectangle, int r, int c) {
        int n = rectangle.length, m = rectangle[0].length;

        if (r >= n)
            return 0;

        if (c >= m)
            return dfs(rectangle, r + 1, 0);

        if (rectangle[r][c])
            return dfs(rectangle, r, c + 1);

        int min = 2000;
        for (int k = Math.min(n-r, m-c); k >= 1 && isFree(rectangle, r, c, k); k--) {
            paint(rectangle, r, c, k);
            min = Math.min(dfs(rectangle, r, c + 1), min);
            revert(rectangle, r, c, k);
        }
        return 1 + min;
    }

    // Check if the area [r, ..., r+k][c, ..., c+k] is alreadc covered
    private boolean isFree(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(rect[r+i][c+j]) return false;
            }
        }
        return true;
    }
    // Cover the area [r, ..., r+k][c, ..., c+k] with a k * k square
    private void paint(boolean[][] rect, int r, int c, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[r+i][c+j] = true;
            }
        }
    }
    // Uncover the area [r, ..., r+k][c, ..., c+k]
    private void revert(boolean[][] rect, int r, int c, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[r+i][c+j] = false;
            }
        }
    }

    public static void main(String[] args) {
        TilingRectangleWithTheFewestSquares tiling = new TilingRectangleWithTheFewestSquares();
        System.out.println(tiling.tilingRectangle(11, 13));
    }
}
