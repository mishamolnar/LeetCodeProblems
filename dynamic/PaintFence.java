package LeetCode.dynamic;

//https://leetcode.com/problems/paint-fence/
public class PaintFence {
    public static void main(String[] args) {
        PaintFence paintFence = new PaintFence();
        System.out.println(paintFence.numWays(7, 2));
    }

    public int numWays(int n, int k) {
        if (n == 1) return k;
        int curr = k * k;
        int same = k;
        for (int i = 2; i < n; i++) {
            int buffSame = same;
            same = curr - buffSame;
            curr = curr * k - buffSame;
        }
        return curr;
    }
}
