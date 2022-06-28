package LeetCode.linkedList;

import java.util.List;

// link - https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head) {
        int size = 1;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        curr = head;
        for (int i = 0; i < size / 2; i++) {
            curr = curr.next;
        }
        curr = reverseList(curr);
        while (curr != null) {
            if (curr.val != head.val) return false;
            curr = curr.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode buff = curr;
            curr = curr.next;
            buff.next = prev;

            prev = buff;
        }

        return prev;
    }

    private class ListNode {
        int val;
        PalindromeLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, PalindromeLinkedList.ListNode next) { this.val = val; this.next = next; }
    }
}
