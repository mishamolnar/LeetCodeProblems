package LeetCode.backTracking;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/maximum-number-of-accepted-invitations/
public class MaximumNumberOfAcceptedInvitations {
    private int max= 0;

    public int maximumInvitations(int[][] grid) {
        backtrack(grid, 0, new HashSet<>());
        return this.max;
    }

    //backtracking, timelimiot exceed O(mn!) complexity
    private void backtrack(int[][] grid, int boy, Set<Integer> invited) {
        if (boy >= grid.length) {
            this.max = Math.max(max, invited.size());
        } else {
            for (int i = 0; i < grid[boy].length; i++) {
                if (invited.contains(i)) continue;
                if (grid[boy][i] == 1) invited.add(i);
                backtrack(grid, boy + 1, new HashSet<>(invited));
                invited.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        MaximumNumberOfAcceptedInvitations max = new MaximumNumberOfAcceptedInvitations();
        System.out.println(max.maximumInvitations(new int[][]{{1,1,1}, {1,0,1}, {0,0,1}}));
    }
}

//There are m boys and n girls in a class attending an upcoming party.
//
//You are given an m x n integer matrix grid, where grid[i][j] equals 0 or 1. If grid[i][j] == 1,
// then that means the ith boy can invite the jth girl to the party.
// A boy can invite at most one girl, and a girl can accept at most one invitation from a boy.
//
//Return the maximum possible number of accepted invitations.
//
//
//
//Example 1:
//
//Input: grid = [[1,1,1],
//               [1,0,1],
//               [0,0,1]]
//Output: 3
//Explanation: The invitations are sent as follows:
//- The 1st boy invites the 2nd girl.
//- The 2nd boy invites the 1st girl.
//- The 3rd boy invites the 3rd girl.
//Example 2:
//
//Input: grid = [[1,0,1,0],
//               [1,0,0,0],
//               [0,0,1,0],
//               [1,1,1,0]]
//Output: 3
//Explanation: The invitations are sent as follows:
//-The 1st boy invites the 3rd girl.
//-The 2nd boy invites the 1st girl.
//-The 3rd boy invites no one.
//-The 4th boy invites the 2nd girl.

//Time limit exceeded  for
//[[0,0,0,0,0,0,0,1,0,0,1,0,0,0,0],
// [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [1,0,0,1,0,1,0,0,0,0,0,0,0,1,0],
// [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0],
// [1,1,0,0,1,0,0,0,0,0,0,0,0,0,0],
// [0,0,0,1,0,1,0,0,0,0,0,0,0,0,0],
// [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [0,0,0,1,0,1,0,0,0,0,0,0,0,1,0],
// [0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],
// [0,0,0,0,0,1,0,0,0,0,0,0,0,1,0],
// [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0],
// [0,0,0,1,0,0,0,0,0,0,0,0,1,0,1],
// [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0],
// [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [0,0,0,1,0,1,0,0,0,0,0,0,0,0,0],
// [0,0,0,1,0,1,0,0,0,0,0,0,0,0,0],
// [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
// [0,0,0,1,0,1,0,0,0,0,0,0,0,1,0]]
