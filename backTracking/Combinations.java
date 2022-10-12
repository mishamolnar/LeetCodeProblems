package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 1, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int start, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(curr);
        } else {
            for (int i = start; i <= n; i++) {
                curr.add(i);
                backtrack(n, i + 1, k, new ArrayList<>(curr), res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
