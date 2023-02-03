package LeetCode.sorting;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        //1, 1, 2, 2
        //5, 5, 6, 4
        //pick up if possible
        //go back if needed to check if there are some older needed to eliminate
        //we eliminate if the player is younger but has bigger score
        //we add the player either if it has the same age or it has smaller score
        int[][] tuples = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            tuples[i][0] = ages[i];
            tuples[i][1] = scores[i];
        }
        Arrays.sort(tuples, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : - Integer.compare(a[1], b[1]));
        boolean[] used = new boolean[ages.length];
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            res = dp(tuples, i, res, used);
        }
        return res;
    }

    private int dp(int[][] tuples, int index, int curr, boolean[] used) {
        int buff = curr, maxScore = tuples[index][1];
        buff += tuples[index][1];
        for (int i = index - 1; i >= 0; i--) {
            if (used[i] && tuples[i][0] < tuples[index][0] && tuples[i][1] > maxScore) {
                buff -= tuples[i][1];
            } else if (!used[i] && (tuples[index][0] == tuples[i][0] || tuples[i][1] < tuples[index][1])) {
                maxScore = Math.min(maxScore, tuples[i][1]);
                buff += tuples[i][1];
            }
        }
        if (buff > curr) {
            maxScore = tuples[index][1];
            used[index] = true;
            for (int i = index - 1; i >= 0; i--) {
                if (used[i] && tuples[i][0] < tuples[index][0] && tuples[i][1] > maxScore) {
                    used[i] = false;
                } else if (!used[i] && (tuples[index][0] == tuples[i][0] || tuples[i][1] < tuples[index][1])) {
                    maxScore = Math.min(maxScore, tuples[i][1]);
                    used[i] = true;
                }
            }
            return buff;
        }
        return curr;
    }

    public static void main(String[] args) {
        BestTeamWithNoConflicts best = new BestTeamWithNoConflicts();
        System.out.println(best.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
    }
}
