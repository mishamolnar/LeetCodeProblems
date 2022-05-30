package LeetCode.linkedList;

//https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
public class InsertIntoSortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node toReturn = new Node(insertVal);
            toReturn.next = toReturn;
            return toReturn;
        }
        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && curr.val >= insertVal) { // знайшли дві ноди, попередня менша або рівна за insertVal, наступна бтльша або рівна за insertVal
                toInsert = true;
            } else if (prev.val > curr.val) { // якщо попередня більша за наступну (злом)
                if (insertVal >= prev.val || insertVal <= curr.val) { // і в той самий час insertVal більша за попередню або менша за наступну
                    toInsert = true;
                }
            }

            if (toInsert) {
                prev.next = new Node(insertVal, curr);
            }

            prev = curr;
            curr = curr.next;
        } while (prev == head);

        prev.next = new Node(insertVal, curr); //якщо пройшли круг і ніде не вставили - тоді всі велечини одинакові і можна вставляти будь де
        return head;
    }

    private class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
