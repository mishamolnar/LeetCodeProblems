package LeetCode.string;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[256];
        int left = 0, count = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            arr[c]++;
            if (arr[c] == 1) count++;
            while (count > k) {
                int deleted = s.charAt(left++);
                arr[deleted]--;
                if (arr[deleted] == 0) count--;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters logest = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(logest.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
