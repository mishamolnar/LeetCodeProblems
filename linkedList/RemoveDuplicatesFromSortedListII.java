package LeetCode.linkedList;


//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII sortedListII = new RemoveDuplicatesFromSortedListII();
        System.out.println(sortedListII.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        Integer lastDupeVal = null;
        ListNode buff = head;
        ListNode newHead = null;
        ListNode curr = null;
        while (buff != null) {
            if (buff.next != null && buff.val == buff.next.val) lastDupeVal = buff.val;
            else if (lastDupeVal == null  || buff.val != lastDupeVal) {
                if (newHead == null) {
                    newHead = buff;
                    curr = newHead;
                } else {
                    curr.next = buff;
                    curr = curr.next;
                }
            }
            buff = buff.next;
        }
        if (curr != null) curr.next = null;
        return newHead;
    }

    private static class ListNode {
        int val;
        RemoveDuplicatesFromSortedListII.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveDuplicatesFromSortedListII.ListNode next) { this.val = val; this.next = next; }
    }
}
