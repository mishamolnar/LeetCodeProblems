package LeetCode.arrays;

import LeetCode.dynamic.PascalsTriangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//
public class PascalsTriangleII {


    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangle = new PascalsTriangleII();
        System.out.println(pascalsTriangle.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
