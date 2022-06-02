package LeetCode.string;

//https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/
public class UniqueSubstringsWithEqualDigitFrequency {

    //O(n2) time and linear space
    public int equalDigitFrequency(String s) {
        Node trie = new Node();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[10];
            int maxCount = 0, unique = 0;
            Node node = trie;
            for (int j = i; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';
                unique += count[digit]++ == 0 ? 1 : 0;
                maxCount = Math.max(maxCount, count[digit]);
                if (node.arr[digit] == null)
                    node.arr[digit] = new Node();
                node = node.arr[digit];
                if (unique * maxCount == j - i + 1 && !node.seen) {
                    node.seen = true;
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueSubstringsWithEqualDigitFrequency unique = new UniqueSubstringsWithEqualDigitFrequency();
        System.out.println(unique.equalDigitFrequency("1212"));
    }

    private class Node{
        private Node[] arr = new Node[10];
        private boolean seen;
    }
}
