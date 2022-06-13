package LeetCode.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
public class HiddenFormula {
    public static void main(String[] args) {
        HiddenFormula hiddenFormula = new HiddenFormula();
        CustomFunction customFunction = new CustomFunction();
        System.out.println(hiddenFormula.findSolution(customFunction, 9));
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1, y = 1;
        while (x < 1001) {
            int right = 1000;
            while (y < right) {
                int mid = (y + right) / 2;
                int res = customfunction.f(x, mid);
                if (res < z) y = mid;
                else right = mid;
            }
            if (customfunction.f(x, y) == z) break;
            x++;
            y = 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (x == 0 || y == 0) return Collections.emptyList();
        int newX = x, newY = y;
        while (customfunction.f(newX, newY) == z  && newY < 1001) {
            while (customfunction.f(newX, newY) == z && newX > 0) {
                result.add(List.of(newX, newY));
                if (customfunction.f(newY, newX) == z) result.add(List.of(newY, newX));
                newX--;
            }
            newY++;
        }
        newX = x;
        newY = y;
        while (customfunction.f(newX, newY) == z && newX < 1001) {
            while (customfunction.f(newX, newY) == z && newY > 1) {
                result.add(List.of(newX, newY));
                if (customfunction.f(newY, newX) == z) result.add(List.of(newY, newX));
                newY--;
            }
            newX++;
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    // This is the custom function interface.
    // You should not implement it, or speculate about its implementation
    static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x * x + y;
        }
    }

}
