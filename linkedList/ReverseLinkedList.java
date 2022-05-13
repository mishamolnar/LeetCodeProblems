package LeetCode.linkedList;

//complexity O(n)
// link - https://leetcode.com/problems/reverse-linked-list/submissions/
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseListTwo(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode buff = new ListNode(head.val);
            buff.next = prev;
            prev = buff;
            head = head.next;
        }
        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode reverseListTwo(ListNode root) {
        return reverseListHelper(root, null);
    }

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode nextHead = head.next; //пройти на наступну ітерацію заданої ноди
        head.next = newHead; //поточній ітерації присвоїти значення заданої ноди плюс інші попередньо перевенуті
        return reverseListHelper(nextHead, head);
    }
}
