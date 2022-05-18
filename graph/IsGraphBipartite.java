package LeetCode.graph;


//https://leetcode.com/problems/is-graph-bipartite/
public class IsGraphBipartite {
    private boolean[] marked;
    private boolean[] colored;
    private boolean isBipartite;

    public static void main(String[] args) {
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        System.out.println(isGraphBipartite.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }

    public boolean isBipartite(int[][] graph) {
        this.marked = new boolean[graph.length];
        this.colored = new boolean[graph.length];
        isBipartite = true;
        for (int i = 0; i < graph.length; i++) {
            dfs(i, graph);
        }
        return isBipartite;
    }

    private void dfs(int v, int[][] graph) {
        if (marked[v]) return;
        marked[v] = true;
        for (int i = 0; i < graph[v].length; i++) {
            if (!marked[graph[v][i]]) {
                colored[graph[v][i]] = !colored[v];
                dfs(graph[v][i], graph);
            } else if (colored[graph[v][i]] == colored[v]) {
                isBipartite = false;
            }
        }
    }
}
