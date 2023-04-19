package LeetCode.arrays;

public class NumArraySegment {
    private int[] tree;
    private int len;

    public NumArraySegment(int[] nums) {
        len = nums.length;
        tree = new int[len * 2];

        System.arraycopy(nums, 0, tree, len, len);

        int pointer = len - 1;
        while (pointer > 0) {
            tree[pointer] = tree[pointer * 2] + tree[pointer * 2 + 1];
            pointer--;
        }
    }

    public void update(int index, int val) {
        tree[len + index] = val;
        int pointer = (len + index) / 2;

        while (pointer > 0) {
            tree[pointer] = tree[pointer * 2] + tree[pointer * 2 + 1];
            pointer /= 2;
        }
    }

    public int sumRange(int left, int right) {
         left += len;
         right += len;
         int res = 0;

         while (right >= left) {
             if (left % 2 == 1) {
                 res += tree[left++];
             }

             if (right % 2 == 0) {
                 res += tree[right--];
             }

             left /= 2;
             right /= 2;
         }
         return res;
    }


    public static void main(String[] args) {
        System.out.println(new NumArraySegment(new int[]{9,2,7,8,6}).sumRange(0, 4));
    }
}
