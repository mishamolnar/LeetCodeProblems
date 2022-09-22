package LeetCode.linkedList;

//https://leetcode.com/problems/linked-list-random-node/
public class LinkedListRandomNode {
    private ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1, value = 0;
        ListNode pointer = head;
        while (pointer != null) {
            if (Math.random() < 1.0 / scope) {
                value = pointer.val;
            }
            scope += 1;
            pointer = pointer.next;
        }
        return value;
    }
    
      private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
