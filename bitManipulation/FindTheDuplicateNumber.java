package LeetCode.bitManipulation;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int dupe = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) dupe = nums[i];  //якщо елемент вже негативний - тоді ми прийшли до нього другий раз і nums[i] - дублікат
            else nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])]; //якщо nums[i] - троєчка - тоді перевертаємо третій елемент в масиві
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = -nums[i];
        }
        return Math.abs(dupe);
    }

    //floyd algo
    public int findDuplicateFloyd(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber find = new FindTheDuplicateNumber();
        System.out.println(find.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(find.findDuplicate(new int[]{2, 2, 2, 2, 2}));
    }
}
