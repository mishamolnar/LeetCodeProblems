package LeetCode.string;


//link - https://leetcode.com/problems/count-and-say/submissions/
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(20));
    }

    public String countAndSay(int n) {
        int count = 1;
        String result = "1";
        while (count != n) {
            result = transform(result);
            count++;
        }
        return result;
    }

    private String transform(String n) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n.length(); i++) {
            if (i == n.length() - 1) {
                stringBuilder.append(count);
                stringBuilder.append(n.charAt(i));
                break;
            }
            if (n.charAt(i) != n.charAt(i + 1)) {
                stringBuilder.append(count);
                stringBuilder.append(n.charAt(i));
                count = 1;
            } else count++;
        }
        return stringBuilder.toString();
    }
}
