package LeetCode.bitManipulation;

// not leetcode task
public class BinaryTransformation {

    public static void main(String[] args) {
        System.out.println(toBinary(75));
        System.out.println(toBinary(142));
        System.out.println(toDecimal("1001011"));
        System.out.println(toDecimal("10001110"));
        System.out.println(toBinary(0));
        System.out.println(toBinary(1));
        System.out.println(toDecimal("0"));
        System.out.println(toDecimal("1"));
    }

    private static String toBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 0) return "0";
        while (n != 0) {
            stringBuilder.append(n % 2);
            n = n / 2;
        }
        return stringBuilder.reverse().toString();
    }

    private static int toDecimal(String binary) {
        int count = 0;
        int result = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            result += Integer.parseInt("" + binary.charAt(i)) * Math.pow(2, count);
            count++;
        }
        return result;
    }
}
