package LeetCode.unionFind;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {

    // time - O(n2) and space - O(n)
    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (j < i) continue; //optimization
                if (isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
    }


    private class UF {
        private int[] id;
        private int count;

        public UF(int count) {
            this.id = new int[count];
            this.count = count;
            for (int i = 0; i < count; i++) {
                id[i] = i;
            }
        }

        private void union(int a, int b) {
            int i = find(a);
            int j = find(b);
            if (i == j) return;
            id[i] = j;
            --count; // віднімаємо один, якщо ми з'єднали дві, до того не з'єднані, провінції
        }

        private int find(int a) {
            return id[a] == a ? a : (id[a] = find(id[a]));
        }
    }
}
