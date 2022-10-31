package LeetCode.graph;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) parents[leftChild[i]]++;
            if (rightChild[i] != -1) parents[rightChild[i]]++;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if ((parents[i] == 0 && root != -1) || parents[i] > 1) return false;
            if (parents[i] == 0) root = i;
        }
        boolean[] visited = new boolean[n];
        dfs(root, leftChild, rightChild, visited);
        for (boolean b : visited) if (!b) return false;
        return true;
    }

    private void dfs(int curr, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (curr == -1) return;
        visited[curr] = true;
        dfs(leftChild[curr], leftChild, rightChild, visited);
        dfs(rightChild[curr], leftChild, rightChild, visited);
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes validate = new ValidateBinaryTreeNodes();
        System.out.println(validate.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
    }
}
