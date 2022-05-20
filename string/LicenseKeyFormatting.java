package LeetCode.string;

//https://leetcode.com/problems/license-key-formatting/submissions/
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    public String licenseKeyFormatting(String s, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        s = s.toUpperCase();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            sb.append(s.charAt(i));
            count++;
            if (count == k) {
                sb.append('-');
                count = 0;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
