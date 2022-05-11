package LeetCode.string;

//link - https://leetcode.com/problems/implement-strstr/
public class ImplementSubStringSearch {
    public static void main(String[] args) {
        ImplementSubStringSearch iss = new ImplementSubStringSearch();
        System.out.println(iss.strStr("hello", "aabaabaaa"));
    }

    // knuth moriss pratt algo - O(N+M)
    // O(m) space
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i; ++j;
                if (j == m) return i - m;  // found solution
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++;  // don't match -> go to next character of `haystack` string
            }
        }
        return -1;
    }

    private int[] computeKMPTable(String pattern) {
        int i = 1, j = 0, n = pattern.length();
        int[] lps = new int[n];
        while (i < n) { //i інкрементиться в любому разі, j тільки коли ми знайшли співпадіння
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = j + 1; // or just ++j
                j++;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return lps;
    }
}
