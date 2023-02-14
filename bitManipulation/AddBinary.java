package LeetCode.bitManipulation;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        for (int i = 1; i <= Math.max(a.length(), b.length()); i++) {
            reminder += (i > a.length()) ? 0 : a.charAt(a.length() - i);
            reminder += (i > b.length()) ? 0 : b.charAt(b.length() - i);
            sb.append(reminder % 2);
            reminder /= 2;
        }
        return sb.reverse().toString();
    }
}
