package LeetCode.graph;

public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        long[] res = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            res[edges[i]] += i;
        }
        int ans = 0;
        long max = -1;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] >= max) {
                max = res[i];
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NodeWithHighestEdgeScore node = new NodeWithHighestEdgeScore();
        System.out.println(node.edgeScore(new int[]{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
