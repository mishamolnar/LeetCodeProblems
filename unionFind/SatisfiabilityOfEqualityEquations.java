package LeetCode.unionFind;

import java.util.Arrays;

public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '!')
                continue;
            unionFind.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                continue;
            if (unionFind.connected(equation.charAt(0) - 'a', equation.charAt(3) - 'a'))
                return false;
        }
        return true;
    }

    private class UnionFind {
        int[] arr;
        int[] sizes;

        UnionFind(int size) {
            this.arr = new int[size];
            this.sizes = new int[size];
            Arrays.fill(sizes, 1);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        boolean connected(int a, int b) {
            return find(a) == find(b);
        }

        int find(int a) {
            int buff = a;
            while (arr[a] != a) {
                a = arr[a];
            }
            arr[buff] = a;
            return a;
        }

        void connect(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            arr[a] = aRoot;
            arr[b] = bRoot;
            if (sizes[aRoot] >= sizes[bRoot]) {
                arr[bRoot] = arr[aRoot];
                sizes[aRoot] += sizes[bRoot];
            } else {
                arr[aRoot] = arr[bRoot];
                sizes[bRoot] += sizes[aRoot];
            }
        }
    }

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations cls = new SatisfiabilityOfEqualityEquations();
        System.out.println(cls.equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
    }
}
