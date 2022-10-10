package LeetCode.backTracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, side, matchsticks.length - 1, 0, 0, 0, 0);
    }

    private boolean backtrack(int[] matchsticks, int side, int index, int top, int bottom, int left, int right) {
        if (side == top && side == bottom && side == left && side == right)
            return true;
        if (side < top || side < bottom || side < left || side < right || index < 0)
            return false;
        boolean res = false;
        res = res || backtrack(matchsticks, side, index - 1, top + matchsticks[index], bottom, left, right);
        if (res) return true;
        res = res || backtrack(matchsticks, side, index - 1, top, bottom + matchsticks[index], left, right);
        if (res) return true;
        res = res || backtrack(matchsticks, side, index - 1, top, bottom, left + matchsticks[index], right);
        if (res) return true;
        res = res || backtrack(matchsticks, side, index - 1, top, bottom, left, right + matchsticks[index]);
        return res;
    }
}
