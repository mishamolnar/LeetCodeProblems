package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/factor-combinations/
public class FactorCombinations {
    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        System.out.println(factorCombinations.getFactors(8192));
    }

    //O(n * log(n)) time, де n кількість результатів і log(n) - час за який дійдеш до результату
    public List<List<Integer>> getFactors(int n) {
        if (n == 1 || n == 2) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    //O(log(n)) extra space complexity - стільки треба що б дійти до кінця рекурсивного стеку
    private void backtrack(List<List<Integer>> result, List<Integer> toAdd, int n, int start) {
        if (n <= 1) {
            if (toAdd.size() > 1) {
                result.add(new ArrayList<>(toAdd));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                toAdd.add(i);
                backtrack(result, new ArrayList<>(toAdd), n / i, i);
                toAdd.remove(toAdd.size() - 1);
            }
        }
    }

}
