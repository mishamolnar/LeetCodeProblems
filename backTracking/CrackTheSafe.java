package LeetCode.backTracking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {
    public static void main(String[] args) {
        System.out.println(String.join("", Collections.nCopies(3, "0")));
    }

    public String crackSafe(int n, int k) {
        String initial = "0".repeat(k);
        StringBuilder sb = new StringBuilder(initial);
        int total = (int) Math.pow(k, n);

        Set<String> combinations = new HashSet<>();
        combinations.add(initial);

        backtrack(sb, combinations, total, n, k);

        return sb.toString();
    }

    private boolean backtrack(StringBuilder sb, Set<String> combinations, int total, int n, int k) {
        if (combinations.size() == total) return true;

        String last  = sb.substring(sb.length() - n + 1);
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = last + ch;
            if (!combinations.contains(newComb)) {
                combinations.add(newComb);
                sb.append(ch);
                if (backtrack(sb, combinations, total, n, k)) {
                    return true;
                }
                combinations.remove(newComb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return false;
    }


}
