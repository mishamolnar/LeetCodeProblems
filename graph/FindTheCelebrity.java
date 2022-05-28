package LeetCode.graph;

import java.util.Arrays;

public class FindTheCelebrity {
    public static void main(String[] args) {
        FindTheCelebrity find = new FindTheCelebrity();
        System.out.println(find.findCelebrity(3));
    }

    public int findCelebrity(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) celebrity = i;
        }
        return -1;
    }

    private boolean isCelebrity(int celebrity, int n) {
        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;
            if (knows(celebrity, i) || !knows(i, celebrity))
                return false;
        }
        return true;
    }

    private boolean knows(int a, int b) {
        int[][] arr = new int[][]{{1, 0, 1}, {1,1,0}, {0,1,1}};
        return arr[a][b] == 1;
    }
}
