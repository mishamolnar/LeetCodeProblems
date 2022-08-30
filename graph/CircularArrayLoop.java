package LeetCode.graph;

public class CircularArrayLoop {
    private static final int NOT_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public boolean circularArrayLoop(int[] nums) {
        int[] tracker = new int[nums.length];
        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] == NOT_VISITED && dfs(nums, tracker, i))
                return true;
        }
        return false;
    }

    private boolean dfs(int[] nums, int[] tracker, int curr) {
        if (tracker[curr] == VISITED) return false;
        if (tracker[curr] == VISITING) return true;

        int next = curr + nums[curr];
        next %= nums.length;
        if (next < 0) next += nums.length;

        if (next == curr || nums[curr] * nums[next] < 0) {
            tracker[curr] = VISITED;
            return false;
        }

        tracker[curr] = VISITING;
        boolean res = dfs(nums, tracker, next);
        tracker[curr] = VISITED;
        return res;
    }
}
