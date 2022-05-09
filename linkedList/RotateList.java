package LeetCode.linkedList;


//link - https://leetcode.com/problems/rotate-list/
public class RotateList {
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        System.out.println(rotateList.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }


    //O(n) time and constant space complexity
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        current.next = head;
        size++;
        for (int i = 0; i < size - (k % size) - 1; i++) {
            head = head.next;
        }
        current = head.next;
        head.next = null;
        return current;
    }


    private static class ListNode {
        int val;
        RotateList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RotateList.ListNode next) { this.val = val; this.next = next; }
    }
}
