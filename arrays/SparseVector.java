package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/dot-product-of-two-sparse-vectors/submissions/
public class SparseVector {
    List<int[]> pairs;

    //hashset is predictable
    //pairs prroach bellow
    SparseVector(int[] nums) {
        this.pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) pairs.add(new int[]{i, nums[i]});
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0, one = 0, two = 0;
        while (one < vec.pairs.size() && two < this.pairs.size()) {
            if (vec.pairs.get(one)[0] == this.pairs.get(two)[0]) {
                result += vec.pairs.get(one)[1] * this.pairs.get(two)[1];
                one++;
                two++;
            } else if (vec.pairs.get(one)[0] > this.pairs.get(two)[0]) {
                two++;
            } else one++;
        }
        return result;
    }
}
