package LeetCode.tree;

import java.util.Arrays;

//https://leetcode.com/problems/build-binary-expression-tree-from-infix-expression/
public class BuildBinaryExpressionTreeFromInfixExpression {

    //O(n) time and space
    public Node expTree(String s) { // s is an expression
        return parseExpression(s.toCharArray(), new int[1]);
    }

    public Node parseExpression(char[] arr, int[] index) { // expression is s or smth in ()
        Node left = parseTerm(arr, index);
        while (index[0] < arr.length && (arr[index[0]] == '+' || arr[index[0]] == '-')) {
            char operator = arr[index[0]++];
            Node right = parseTerm(arr, index);
            left = new Node(operator, left, right);
        }
        return left;
    }

    private Node parseTerm(char[] arr, int[] index) {
        Node left = parseFactor(arr, index);
        while (index[0] < arr.length && (arr[index[0]] == '*' || arr[index[0]] == '/')) {
            char operand = arr[index[0]++];
            Node right = parseFactor(arr, index);
            left = new Node(operand, left, right);
        }
        return left;
    }

    public Node parseFactor(char[] arr, int[] index) {
        if (arr[index[0]] == '(') {
            index[0]++; //pass '('
            Node n = parseExpression(arr, index);
            index[0]++; //pass ')'
            return n;
        }
        return new Node(arr[index[0]++], null, null);
    }

    //M2: define a BNF
    //exp := s
    //s := term | term {[+, -] term}
    //term := factor | factor {[*, /] factor}
    //factor := digit | '(' exp ')'


    public static void main(String[] args) {
        BuildBinaryExpressionTreeFromInfixExpression build = new BuildBinaryExpressionTreeFromInfixExpression();
        System.out.println(build.expTree("3*4-2*5"));
    }

    private static class Node {
        char val;
        Node left;
        Node right;
        Node() {this.val = ' ';}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
