package LeetCode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;



//https://leetcode.com/problems/next-permutation/submissions/
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutationTwo(new int[]{3, 2, 1});
        //4,2,0,9,9,8
    }

    public void nextPermutationTwo(int[] nums) {
        int pointerMin = nums.length - 2;
        while (pointerMin >= 0 && nums[pointerMin] >= nums[pointerMin + 1]) pointerMin--;
        if (pointerMin >= 0) {
            int pointerNextMin = pointerMin + 1;
            while (pointerNextMin < nums.length && nums[pointerNextMin] > nums[pointerMin]) pointerNextMin++;
            swap(nums, pointerNextMin, pointerMin);
        }
        reverse(nums, pointerMin + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    //space - O(1)
    //time - O(nlog(n))
    public void nextPermutation(int[] nums) {
        int toReplace = nums[nums.length - 1];
        int startSort = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (toReplace > nums[i]) {
                int j = i + 1;
                while (j < nums.length - 1 && (j + 1 == nums.length || nums[i] < nums[j + 1])) {
                    j++;
                }
                swap(nums, i, j);
                startSort = i + 1;
                break;
            }
            toReplace = Math.max(toReplace, nums[i]);
        }
        Arrays.sort(nums, startSort, nums.length);
        System.out.println("done");
    }

    private void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}
