package LeetCode.arrays;

import java.util.Arrays;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] < 0) continue;
            int curr = nums[i], index = i;
            while (curr > 0) {
                int nextIndex = getIndex(index, size);
                int next = nums[nextIndex];
                nums[nextIndex] = -curr;
                curr = next;
                index = nextIndex;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }


    private int getIndex(int index, int size) {
        return index < size / 2 ? index * 2 : (index - (size / 2) + 1) * 2 - 1;
    }

    public static void main(String[] args) {
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        System.out.println(Arrays.toString(shuffleTheArray.shuffle(new int[]{1, 2, 3, 4}, 2)));
    }
}
