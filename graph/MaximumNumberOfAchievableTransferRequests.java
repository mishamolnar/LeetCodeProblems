package LeetCode.graph;

public class MaximumNumberOfAchievableTransferRequests {

    //bitmask + combinations
    public int maximumRequests(int n, int[][] requests) {
        return backtrack(n, requests, 0, 0);
    }

    private int backtrack(int n, int[][] requests, int state, int requestNumber) {
        if (requestNumber >= requests.length)
            return 0;
        int stateWithCurr = state | (1 << requestNumber), res = 0;
        if (checkIfValid(n, requests, state))
            res = Math.max(res, Integer.bitCount(state));
        if (checkIfValid(n, requests, stateWithCurr))
            res = Math.max(res, Integer.bitCount(stateWithCurr));
        return Math.max(res, Math.max(
                backtrack(n, requests, state, requestNumber + 1),
                backtrack(n, requests, stateWithCurr, requestNumber + 1)));
    }

    private boolean checkIfValid(int n, int[][] requests, int state) {
        int[] buildings = new int[n];
        for (int i = 0; i < requests.length; i++) {
            if ((state & (1 << i)) > 0) {
                buildings[requests[i][0]]--;
                buildings[requests[i][1]]++;
            }
        }
        for (int building : buildings) {
            if (building != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
        System.out.println(Integer.bitCount(12));
    }
}
