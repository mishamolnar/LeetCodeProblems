package LeetCode.dynamic;

//given length of rod (шнура) and prices for each length.
// to do: get max value that you can get by dividing rod
// no link, exercise from introduction to algorithms page 364
public class RodCutProblem {
    public static void main(String[] args) {
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(bottomUpCutRoad(prices, 4));
    }

    private static int bottomUpCutRoad(int[] p, int n) {
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) { // increasing the size of subarray we are working with, from 1 to n (0 is always 0)
            int q = -1000;
            for (int i = 1; i <= j; i++) { // for example if we are calculating maximum price for length 4 we are calculating price for [1, 3], [2, 2,], [4, 0]
                if (q < p[i] + r[j - i]) {
                    q = p[i] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        printPath(s, n);
        return r[n];
    }

    private static void printPath(int[] s, int n) {
        while (n != 0) {
            System.out.print(s[n]);
            System.out.println(" ");
            n = n - s[n];
        }
    }

    // dynamic programming with memoization
    private static int memorizedCutRod(int[] p, int n) {
        int[] r = new int[n + 1]; // array for memoization
        for (int i = 0; i <= n; i++) {
            r[i] = -1000;
        }
        return memoizedCutRodAux(p, n, r);
    }

    private static int memoizedCutRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = -1000;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memoizedCutRodAux(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }
}
