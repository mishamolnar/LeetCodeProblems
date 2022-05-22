package LeetCode.linkedList;


//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/
public class ConvertBinaryNumberInLinkedListToInteger {

    public static void main(String[] args) {
        ConvertBinaryNumberInLinkedListToInteger convert = new ConvertBinaryNumberInLinkedListToInteger();
        System.out.println(convert.getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1)))));
    }

    public int getDecimalValue(ListNode head) {
        return helper(head)[1];
    }

    private int[] helper(ListNode head) {
        if (head.next == null) return new int[]{0, head.val};
        int[] arr = helper(head.next);
        return new int[]{arr[0] + 1, (int) (Math.pow(2, arr[0] + 1) * head.val + arr[1])};
    }


    private static class ListNode {
        int val;
        ConvertBinaryNumberInLinkedListToInteger.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ConvertBinaryNumberInLinkedListToInteger.ListNode next) { this.val = val; this.next = next; }
    }
}
