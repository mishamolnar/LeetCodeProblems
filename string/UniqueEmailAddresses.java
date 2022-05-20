package LeetCode.string;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        System.out.println(uniqueEmailAddresses.formatEmail("t.e.s.t.email+al.ex@leetcode.com"));
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) set.add(formatEmail(email));
        return set.size();
    }

    private String formatEmail(String mail) {
        StringBuilder sb = new StringBuilder();
        boolean skip = false;
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == '@') {
                sb.append(mail.substring(i));
                break;
            } else if (mail.charAt(i) == '.' || skip) continue;
            else if (mail.charAt(i) == '+') skip = true;
            else sb.append(mail.charAt(i));
        }
        return sb.toString();
    }
}
