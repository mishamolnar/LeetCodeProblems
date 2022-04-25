package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.List;

//link - https://leetcode.com/problems/pascals-triangle/submissions/
public class PascalsTriangle {
    private final List<List<Integer>> rows = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (rows.size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            rows.add(list);
        }
        while (rows.size() < numRows) {
            List<Integer> list = new ArrayList<>(rows.get(rows.size() - 1).size() + 1);
            list.add(1);
            for (int i = 1; i <= rows.get(rows.size() - 1).size() - 1; i++){
                list.add(rows.get(rows.size() - 1).get(i) + rows.get(rows.size() - 1).get(i - 1));
            }
            list.add(1);
            rows.add(list);
        }
        return rows.subList(0, numRows);
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        pascalsTriangle.generate(10).forEach(System.out::println);
    }
}
