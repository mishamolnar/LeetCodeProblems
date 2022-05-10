package LeetCode.linkedList;

import java.math.BigDecimal;
import java.math.RoundingMode;

//link - https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        long a = 9999999991L;
        long b = 9L;
        System.out.println(a + b);
        addTwoNumbers.addTwoNumbers(new ListNode(9), new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        AddTwoNumbers.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, AddTwoNumbers.ListNode next) { this.val = val; this.next = next; }
    }
}
