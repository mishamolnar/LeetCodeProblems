package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        VerifyPreorderSequenceInBinarySearchTree verify = new VerifyPreorderSequenceInBinarySearchTree();
        System.out.println(verify.verifyPreorderConstantSapce(new int[]{5,2,1,3,6}));
    }

    //O(1) space and linear time
    public boolean verifyPreorderConstantSapce(int[] preorder) {
        int prevMax = Integer.MIN_VALUE, stackPointer = -1;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < prevMax) return false;
            while (stackPointer >= 0 && preorder[i] > preorder[stackPointer]) {
                prevMax = preorder[stackPointer--];
            }
            preorder[++stackPointer] = preorder[i];
        }
        return true;
    }

    //linear time and space
    public boolean verifyPreorder(int[] preorder) {
        int prevMax = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < prevMax) return false;
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                prevMax = Math.max(stack.pop(), prevMax);
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}
