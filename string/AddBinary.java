package LeetCode.string;


//https://leetcode.com/problems/add-binary/submissions/
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("0", "1011"));
    }

    public String addBinary(String a, String b) {
        char[] result = (!a.equals("0") && !b.equals("0")) ? new char[Math.max(a.length() + 1, b.length() + 1)] : new char[Math.max(a.length(), b.length())];
        int aRight = a.length() - 1, bRight = b.length() - 1, right = result.length - 1;
        int carry = 0;
        while (right >= 0) {
            int current = (aRight >= 0 ? a.charAt(aRight--) - '0' : 0) + (bRight >= 0 ? b.charAt(bRight--) - '0' : 0) + carry;
            if (current > 1) {
                current = current - 2;
                carry = 1;
            } else carry = 0;
            result[right--] = (char) (48 + current);
        }
        return result[0] != '0' || result.length == 1 ? String.valueOf(result) : String.valueOf(result).substring(1, result.length);
    }
}
