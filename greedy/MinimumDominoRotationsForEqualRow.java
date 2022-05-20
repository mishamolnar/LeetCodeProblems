package LeetCode.greedy;

import java.util.PriorityQueue;

//
public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow min = new MinimumDominoRotationsForEqualRow();
        System.out.println(min.minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
    }


    public int minDominoRotationsOnePass(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length) { return -1; }
        int[] countTops = new int[7]; // countA[i] records the occurrence of i in A.
        int[] countBots = new int[7]; // countB[i] records the occurrence of i in B.
        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
        for (int i = 0; i < tops.length; i++) {
            ++countTops[tops[i]];
            ++countBots[bottoms[i]];
            if (tops[i] == bottoms[i]) ++same[tops[i]];
        }
        for (int i = 0; i < 7; i++) {
            if (countTops[i] + countBots[i] - same[i] == tops.length)
                return Math.min(countBots[i], countTops[i]) - same[i];
        }
        return -1;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCount = new int[7], bottomCount = new int[7];
        for (int i = 0; i < tops.length; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
        }
        PriorityQueue<Integer> top = new PriorityQueue<>((a, b) -> topCount[b] - topCount[a]);
        PriorityQueue<Integer> bottom = new PriorityQueue<>((a, b) -> bottomCount[b] - bottomCount[a]);
        for (int i = 1; i < 7; i++) {
            top.add(i);
            bottom.add(i);
        }
        while (!top.isEmpty()) {
            int curr = (bottom.isEmpty() || bottomCount[bottom.peek()] < topCount[top.peek()]) ? top.poll() : bottom.poll();
            int res = checkIfPossible(tops, bottoms, curr);
            if (res != - 1) return res;
        }
        return -1;
    }

    private int checkIfPossible(int[] tops, int[] bottoms, int t) {
        int top = 0;
        int bot = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != t && bottoms[i] != t) return -1;
            if (tops[i] == t && bottoms[i] == t) continue;
            if (tops[i] == t) bot++;
            else top++;
        }
        return Math.min(top, bot);
    }
}
