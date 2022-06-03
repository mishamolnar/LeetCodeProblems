package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
abstract class Node {
    public abstract int evaluate();

    public static Node from(String value) {
        switch(value) {
            case "+":
                return new AdditionNode();
            case "-":
                return new SubtractionNode();
            case "*":
                return new MultiplicationNode();
            case "/":
                return new DivisionNode();
            default:
                return new NumericalNode(value);
        }
    }
};

abstract class OperatorNode extends Node {
    protected Node left;
    protected Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class AdditionNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class SubtractionNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultiplicationNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivisionNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}

class NumericalNode extends Node {
    private String value;

    public NumericalNode(String v) {
        value = v;
    }

    public int evaluate() {
        return Integer.valueOf(value);
    }
}

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> st = new Stack<>();

        for (String s : postfix) {
            Node n = Node.from(s);
            if (n instanceof NumericalNode) {
                st.push(n);
            } else if (n instanceof OperatorNode) {
                OperatorNode op = (OperatorNode) n;
                op.setRight(st.pop());
                op.setLeft(st.pop());
                st.push(op);
            } else {
                throw new IllegalStateException("node should be instance of NumericalNode or OperatorNode");
            }
        }

        return st.pop();
    }
};