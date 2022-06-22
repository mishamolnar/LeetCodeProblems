package LeetCode.arrays;

//https://leetcode.com/problems/minimum-health-to-beat-game/
public class MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 1, max = 0;
        for (int i : damage) {
            max = Math.max(max, i);
            sum += i;
        }
        return sum - Math.min(max, armor);
    }
}
