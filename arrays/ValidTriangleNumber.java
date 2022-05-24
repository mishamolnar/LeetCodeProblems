package LeetCode.arrays;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        System.out.println(validTriangleNumber.triangleNumber(new int[]{4,2,3,4}));
    }

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums); //сортуємо
        int res = 0;
        for (int i = 2; i < nums.length; i++) { //nums[i] > nums[right] > nums[left]
            int left = 0, right = i - 1;
            while (left < right) { //права і ліва не мають співпадати
                if (nums[i] < nums[right] + nums[left]) { // якщо найменша і найбільша сторони формують трикутник - тоді і все між ними теж
                    res += right - left; //додаємо все між сторонами, бо це к-сть комбінацій
                    right--; //зменшуємо праву (більшу) сторону для того шо б подивитись чи в такому випадку будуть формуватись унікальні комбінації
                } else left++; //якщо не валідний трикутник збільшуємо праву сторону що б зробити валідним, праву уже нікуди збільшувати
            }
        }
        return res;
    }
}
