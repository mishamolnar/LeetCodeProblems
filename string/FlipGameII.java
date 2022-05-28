package LeetCode.string;

import java.util.HashMap;

//https://leetcode.com/problems/flip-game-ii/
public class FlipGameII {

    public boolean canWin(String currentState) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return backtrack(new StringBuilder(currentState), dp);
    }

    //O(n!!) time and space
    //T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)
    private boolean backtrack(StringBuilder sb, HashMap<String, Boolean> dp) {
        if (dp.containsKey(sb.toString())) return dp.get(sb.toString());
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.replace(i, i + 2, "--");
                if (!backtrack(new StringBuilder(sb), dp)) {
                    dp.put(sb.toString(), false);
                    sb.replace(i, i + 2, "++");
                    dp.put(sb.toString(), true);
                    return true;
                }
                sb.replace(i, i + 2, "++");
            }
        }
        dp.put(sb.toString(), false);
        return false;
    }

    public static void main(String[] args) {
        FlipGameII flipGameII = new FlipGameII();
        System.out.println(flipGameII.canWin("+++++"));
    }

}
