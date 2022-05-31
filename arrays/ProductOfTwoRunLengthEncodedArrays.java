package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
public class ProductOfTwoRunLengthEncodedArrays {

    //constant space and O(n) time where n - encoded1.length
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int one = 0, two = 0;
        while (one < encoded1.length && two < encoded2.length) {
            int shift = Math.min(encoded1[one][1], encoded2[two][1]);
            int val = encoded1[one][0] * encoded2[two][0];
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == val)
                result.get(result.size() - 1).set(1, result.get(result.size() - 1).get(1) + shift);
            else result.add(new ArrayList<>(List.of(val, shift)));
            encoded1[one][1] -= shift;
            encoded2[two][1] -= shift;
            if (encoded1[one][1] == 0) one++;
            if (encoded2[two][1] == 0) two++;
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfTwoRunLengthEncodedArrays product = new ProductOfTwoRunLengthEncodedArrays();
        System.out.println(product.findRLEArray(new int[][]{{1,3},{2,1},{3,2}}, new int[][]{{2,3},{3,3}}));
    }
}
