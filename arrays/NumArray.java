package LeetCode.arrays;

//https://leetcode.com/problems/range-sum-query-mutable/submissions/
public class NumArray {
    private int[] nums;
    private int[] tree;

    //O(n) initialization and log(n) sum and update
    //Fenwick algo
    public NumArray(int[] nums) {
        this.nums = nums;
        int[] tree = new int[nums.length + 1];
        System.arraycopy(nums, 0, tree, 1, nums.length);
        for (int i = 1; i < tree.length; i++) {
            int parentIndex = i + (i & (-i));
            if  (parentIndex < tree.length) {
                tree[parentIndex] += tree[i];
            }
        }
        this.tree = tree;
    }

    public void update(int index, int val) {
        int toAdd = val - nums[index];
        nums[index] = val;
        index++;
        while (index < tree.length) {
            tree[index] += toAdd;
            index += (-index) & index;
        }
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    private int sum(int right) {
        int sum = 0;
        while (right > 0) {
            sum += tree[right];
            right -= right & (-right);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
        System.out.println((-8 ) & 8);
        System.out.println(Integer.toBinaryString(-8));
    }

}
