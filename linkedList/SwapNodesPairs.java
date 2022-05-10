package LeetCode.linkedList;


//link - https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesPairs {
    public static void main(String[] args) {
        SwapNodesPairs swapNodesPairs = new SwapNodesPairs();
        swapNodesPairs.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
    }

    // O(n) time and constant space
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head.next;
        head.next = swapPairs(head.next.next);
        prev.next = head;
        return prev;
    }

    public ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = head.next;
        ListNode curr = head;
        while (curr != null || curr.next != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
            if (curr != null && curr.next != null) temp.next = curr.next;
        }
        return result;
    }

    private static class ListNode {
        int val;
        SwapNodesPairs.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, SwapNodesPairs.ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
