package LeetCode.string;

//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }

    // O(n) time and constant space solution
    public boolean isIsomorphic(String s, String t) {
        Integer[] arr = new Integer[256];
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == null) arr[s.charAt(i)] = (int) t.charAt(i);
            else if (arr[s.charAt(i)] != (int) t.charAt(i)) return false;
        }
        Integer[] arr2 = new Integer[256];
        for (int i = 0; i < s.length(); i++) {
            if (arr2[t.charAt(i)] == null) arr2[t.charAt(i)] = (int) s.charAt(i);
            else if (arr2[t.charAt(i)] != (int) s.charAt(i)) return false;
        }
        return true;
    }
}
