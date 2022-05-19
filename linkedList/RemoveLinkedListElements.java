package LeetCode.linkedList;


//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        System.out.println(removeLinkedListElements.removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(5))))), 6));
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode result = new ListNode();
        result.next = head;
        ListNode iterator = result.next;
        ListNode lastNotVal = result;
        while (iterator != null) {
            if (iterator.val != val) {
                lastNotVal.next = iterator;
                lastNotVal = lastNotVal.next;
            }
            iterator = iterator.next;
        }
        lastNotVal.next = null;
        return result.next;
    }

    //recursion
    public ListNode removeElementsTwo(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsTwo(head.next, val);
        return head.val == val ? head.next : head;
    }


    private static class ListNode {
        int val;
        RemoveLinkedListElements.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveLinkedListElements.ListNode next) { this.val = val; this.next = next; }
    }
}
