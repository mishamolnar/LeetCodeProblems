package LeetCode.linkedList;

import java.util.HashSet;

// link - https://leetcode.com/problems/linked-list-cycle/
// complexity - O(n) time and space
//there is option with no extra space - if we are comparing 2 nodes, one of them will be 2 times faster
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            } else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    private class ListNode {
        int val;
        LinkedListCycle.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, LinkedListCycle.ListNode next) { this.val = val; this.next = next; }
    }
}
