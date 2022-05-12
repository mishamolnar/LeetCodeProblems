package LeetCode.linkedList;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {

    //O(m + n) time and use only O(1) memory
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sumA = 0;
        ListNode curr = headA;
        while (curr != null) { //обчислюємо суму всього першого листа
            sumA += curr.val;
            curr = curr.next;
        }
        int sumB = 0;
        curr = headB;
        while (curr != null) { //обчислюємо суму всього другого листа
            sumB += curr.val;
            curr = curr.next;
        }
        while (sumA != 0 && sumB != 0 && headA != null && headB != null) { // віднімаємо від більшої з загальних сум
            if (sumA == sumB && headA == headB) return headA; //якщо суми однакові - то перевіряємо чи не однакові елементи
            else if (sumA >= sumB) {
                sumA -= headA.val;
                headA = headA.next;
            } else {
                sumB -= headB.val;
                headB = headB.next;
            }
        }
        return null;
    }

    
    public ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while (aPointer != bPointer) {
            aPointer = aPointer == null ? headB : aPointer.next;
            bPointer = bPointer == null ? headA : bPointer.next;
        }
        return aPointer;
    }

    private class ListNode {
        int val;
        IntersectionOfTwoLinkedLists.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, IntersectionOfTwoLinkedLists.ListNode next) { this.val = val; this.next = next; }
    }

}
