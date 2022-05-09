package LeetCode.arrays;

//link - https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero motr = new MinimumOperationsToReduceXToZero();
        System.out.println(motr.minOperations(new int[]{1,1},
        3));
    }

    //space - O(1)
    //time - O(n)
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (Integer i : nums) {
            totalSum += i; // обчислюємо повну суму масиву (всіх елементів)
        }
        int left = 0;
        int currentSum = 0;
        int sumOfSubarray = totalSum - x; //це сума частини масиву, яку ми будемо шукати, наприклад для [1,1,4,2,3], x = 5 це 6, бо сума 11 - 5 (x) = 6
        if (sumOfSubarray < 0) return -1; // якщо сума всього масиву менша шукому суму - то відповіді немає
        int lengthOfSubarray = Integer.MIN_VALUE; //довжина підмасиву, сума якого sumOfSubarray
        for (int i = 0; i < nums.length; i++) { //шукаємо найдовшу послідовність, сума якої sumOfSubarray
            currentSum += nums[i];
            while (currentSum > sumOfSubarray) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == sumOfSubarray) {
                lengthOfSubarray = Math.max(lengthOfSubarray, i - left);
            }
        }
        return lengthOfSubarray == Integer.MIN_VALUE ? -1 : nums.length - lengthOfSubarray - 1;
    }
}
