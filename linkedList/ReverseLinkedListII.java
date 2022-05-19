package LeetCode.linkedList;


// - https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        System.out.println(reverseLinkedListII.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),2,4));
        reverseLinkedListII.reverseBetween(new ListNode(3, new ListNode(5)), 1,2);
//        reverseLinkedListII.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 3,3);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int len = right - left + 1;
        if (len <= 1 || left < 1 || right < 1) return head;
        ListNode bol = new ListNode (0), slow = bol, fast = bol;
        bol.next = head;
        while (left-- > 1) if ((slow = slow.next) == null) return head;
        while (right-- > 0) if ((fast = fast.next) == null) return head;
        ListNode cur = slow.next, prev = fast.next;
        slow.next = fast;
        for (int i = 0; i < len; i++) {
            ListNode cur_next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = cur_next;
        }
        return bol.next;
    }



    private static class ListNode {
        int val;
        ReverseLinkedListII.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedListII.ListNode next) { this.val = val; this.next = next; }
    }
}
