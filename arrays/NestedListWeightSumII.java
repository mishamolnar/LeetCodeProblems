package LeetCode.arrays;

import java.util.List;

//https://leetcode.com/problems/nested-list-weight-sum-ii/
public class NestedListWeightSumII {
    private int maxDepth = 0;
    private int sum = 0;

    //O(n) time
    //O(n) space in worst case if there is single integer in maxDepth
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int product = helper(nestedList, 1);
        return ((maxDepth + 1) * sum - product);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        maxDepth = Math.max(depth, maxDepth);
        int product = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger();
                product += depth * ni.getInteger();
            } else product += helper(ni.getList(), depth + 1);
        }
        return product;
    }


    private interface NestedInteger {
        // Constructor initializes an empty nested list.

        // Constructor initializes a single integer.

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedListWeightSumII.NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedListWeightSumII.NestedInteger> getList();
    }
}
