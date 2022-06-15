package LeetCode.linkedList;

import java.util.List;

public class ReverseLinkedListIII {

    //recursive implementation
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRec(head.next); //повертає ту саму ноду
        head.next.next = head; //head.next.next - завжди остання нода в листі newHead, тепер ми зациклюємо
        head.next = null; // обриваємо вже зациклений лист
        return newHead;
    }

    //iterative solution
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode buff = curr;
            curr = curr.next;
            buff.next = prev;
            prev = buff;
        }
        return prev;
    }

    //Iterative two
    public ListNode reverseListIt(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3)));
        ReverseLinkedListIII reverse = new ReverseLinkedListIII();
        ListNode reverted = reverse.reverseListRec(one);
        System.out.println(reverted);
    }

    private static class ListNode {
        int val;
        ReverseLinkedListIII.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedListIII.ListNode next) { this.val = val; this.next = next; }
    }
}
