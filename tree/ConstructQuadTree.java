package LeetCode.tree;

//https://leetcode.com/problems/construct-quad-tree/submissions/
public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    private Node construct(int[][] grid, int left, int top, int bottom, int right) {
        if (bottom == top && left == right)
            return new Node(grid[top][left] == 1, true);
        int midHeight = top + (bottom - top) / 2;
        int midWidth = left + (right - left) / 2;
        Node topLeft = construct(grid, left, top, midHeight, midWidth);
        Node topRight = construct(grid, midWidth + 1, top, midHeight, right);
        Node bottomLeft = construct(grid, left, midHeight + 1, bottom, midWidth);
        Node bottomRight = construct(grid, midWidth + 1, midHeight + 1, bottom, right);
        if ((topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) && ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) || (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
            return new Node(topLeft.val, true);
        } else return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {
        ConstructQuadTree constructQuadTree = new ConstructQuadTree();
        System.out.println(constructQuadTree.construct(new int[][]{{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}}));
    }

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
