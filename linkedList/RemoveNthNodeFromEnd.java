package LeetCode.linkedList;

//link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        RemoveNthNodeFromEnd RemoveNthNodeFromEnd = new RemoveNthNodeFromEnd();
            System.out.println(RemoveNthNodeFromEnd.removeNthFromEnd(new RemoveNthNodeFromEnd.ListNode(1, new RemoveNthNodeFromEnd.ListNode(2)), 2));
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        slow.next = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    //O(n) time and constant space complexity
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 1;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        current = head;
        for (int i = 0; i < size - n - 1; i++) {
            if (current.next == null) break;
            current = current.next;
        }
        if (current == head && size == n) return head.next;
        else current.next = current.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        RemoveNthNodeFromEnd.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveNthNodeFromEnd.ListNode next) { this.val = val; this.next = next; }
    }
}
