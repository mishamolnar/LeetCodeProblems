package LeetCode.linkedList;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast.next == null || fast.next.next == null)
            return null;
        else slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

     private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
