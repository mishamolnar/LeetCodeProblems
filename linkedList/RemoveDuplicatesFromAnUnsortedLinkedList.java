package LeetCode.linkedList;

import java.util.HashMap;

//https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
public class RemoveDuplicatesFromAnUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode buff = head;
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (buff != null) {
            if (map.containsKey(buff.val)) map.put(buff.val, true);
            else map.put(buff.val, false);
            buff = buff.next;
        }
        buff = dummy;
        while (buff != null && buff.next != null) {
            if (map.get(buff.next.val)) buff.next = buff.next.next;
            else buff = buff.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(1, new ListNode(2))));
        RemoveDuplicatesFromAnUnsortedLinkedList remove = new RemoveDuplicatesFromAnUnsortedLinkedList();
        remove.deleteDuplicatesUnsorted(head);
    }


    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
