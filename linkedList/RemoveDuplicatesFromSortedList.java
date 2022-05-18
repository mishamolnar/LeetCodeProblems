package LeetCode.linkedList;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode buff = head;
        while (buff.next != null) {
            if (buff.val == buff.next.val) buff.next = buff.next.next;
            else buff = buff.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        RemoveDuplicatesFromSortedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveDuplicatesFromSortedList.ListNode next) { this.val = val; this.next = next; }
    }
}
