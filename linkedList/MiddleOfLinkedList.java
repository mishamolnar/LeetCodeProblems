package LeetCode.linkedList;


// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        System.out.println(middleOfLinkedList.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));

    }


    public ListNode middleNode(ListNode head) {
        ListNode buff = head;
        int size = 0;
        while (buff != null) {
            buff = buff.next;
            size++;
        }
        size = size / 2;
        for (int i = 0; i < size; i++) head = head.next;
        return head;
    }

    private static class ListNode {
        int val;
        MiddleOfLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MiddleOfLinkedList.ListNode next) { this.val = val; this.next = next; }
    }
}
