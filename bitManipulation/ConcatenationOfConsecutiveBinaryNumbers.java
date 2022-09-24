package LeetCode.bitManipulation;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(Integer.toString(i, 2));
        }

        return (int) (Long.parseLong(sb.toString(), 2) % (Math.pow(10, 9) + 7));
    }
}
