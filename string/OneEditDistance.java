package LeetCode.string;

//https://leetcode.com/problems/one-edit-distance/submissions/
public class OneEditDistance {

    public static void main(String[] args) {
        OneEditDistance oneEditDistance = new OneEditDistance();
        System.out.println(oneEditDistance.isOneEditDistance("ab", "acd"));
    }

    public boolean isOneEditDistance(String s, String t) {
        boolean replace = false, delete = false;
        int lengthDiff = Math.abs(s.length() - t.length());
        if (lengthDiff > 1) return false;
        if (lengthDiff == 1) return oneCharacterToReplace(s, t);
        return equalsExceptOne(s, t);
    }

    private boolean oneCharacterToReplace(String s, String t) {
        //i for s and j for t
        if (s.substring(0, Math.min(s.length(), t.length())).equals(t.substring(0, Math.min(s.length(), t.length())))) return true;
        for (int i = 0, j = 0; i < Math.max(s.length(), t.length()) && j < Math.max(s.length(), t.length()); i++, j++) {
            if (s.charAt(i) == t.charAt(j)) continue;
            else {
                if (s.length() > t.length()) i++;
                else j++;
                return s.substring(i).equals(t.substring(j));
            }
        }
        return true;
    }

    private boolean equalsExceptOne(String s, String t) {
        boolean replaced = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i) && !replaced) replaced = true;
            else if (s.charAt(i) != t.charAt(i) && replaced) return false;
        }
        return replaced;
    }
}
