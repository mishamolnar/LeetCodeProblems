package LeetCode.math;

//link - https://leetcode.com/problems/add-digits/
public class AddDigits {

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(10));
    }

    public int addDigits(int num) {
        while (num > 9) {
            String s = String.valueOf(num);
            num = s.chars().reduce(0, (a, b) -> a + b - 48);
        }
        return num;
    }
}
