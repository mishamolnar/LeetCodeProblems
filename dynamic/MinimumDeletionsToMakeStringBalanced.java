package LeetCode.dynamic;

//https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        //aaaaaaabbbbbbbbbb
        int bCount = 0, aCount = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b')
                bCount++;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            res = Math.min(res, bCount + aCount);

            if (s.charAt(i) == 'b')
                bCount--;
            else aCount++;
        }

        return Math.min(res, bCount + aCount);
    }
}
