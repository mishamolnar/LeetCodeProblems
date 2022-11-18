package LeetCode.dynamic;

//https://leetcode.com/problems/filling-bookcase-shelves/description/
public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] heights = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            heights[i] = i > 0 ? heights[i - 1] + books[i][1] : books[i][1];
            int width = books[i][0], hei = books[i][1];
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width <= shelfWidth) {
                    hei = Math.max(hei, books[j][1]);
                    int prev = j == 0 ? 0 : heights[j - 1];
                    heights[i] = Math.min(heights[i], prev + hei);
                } else break;
            }
        }
        return heights[books.length - 1];
    }
}
