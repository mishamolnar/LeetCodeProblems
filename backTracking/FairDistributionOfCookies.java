package LeetCode.backTracking;

import java.util.Arrays;

public class FairDistributionOfCookies {
    private int min = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        backtrack(cookies, new int[k], 0);
        return min;
    }

    private void backtrack(int[] cookies, int[] children, int start) {
        if (start == cookies.length) {
            int curr = 0;
            for (int child : children) {
                curr = Math.max(curr, child);
            }
            this.min = Math.min(curr, this.min);
        } else {
            for (int i = 0; i < children.length; i++) {
                children[i] += cookies[start];
                backtrack(cookies, children.clone(), start + 1);
                children[i] -= cookies[start];
            }
        }
    }

    public static void main(String[] args) {
        FairDistributionOfCookies ofCookies = new FairDistributionOfCookies();
        System.out.println(ofCookies.distributeCookies(new int[]{8,15,10,20,8}, 2));
    }
}
