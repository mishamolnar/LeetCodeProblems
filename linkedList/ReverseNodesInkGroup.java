package LeetCode.linkedList;

//https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
public class ReverseNodesInkGroup {
    ListNode dummy = new ListNode(1);

    public ListNode reverseKGroup(ListNode head, int k) {
        while (head != null) {
            ListNode start = head;
            ListNode end = start;
            boolean full = false;
            for (int i = 1; i <= k; i++) {
                if (end == null) break;
                if (i == k) {
                    ListNode buff = end.next;
                    end.next = null;
                    end = buff;
                    full = true;
                } else end = end.next;
            }
            if (full) {
                append(reverse(start));
            } else append(start);
            head = end;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode buff = node.next;
            node.next = prev;

            prev = node;
            node = buff;
        }

        return prev;
    }

    private void append(ListNode node) {
        ListNode buff = dummy;
        while (buff.next != null) {
            buff = buff.next;
        }

        buff.next = node;
    }

    public static void main(String[] args) {

    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
