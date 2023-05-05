package LeetCode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SegmentTree {
    private final int[] arr;


    public SegmentTree(int[] arr) {
        int n = arr.length;
        this.arr = new int[4 * n];
        build(arr, 1, 0, arr.length - 1);
    }

    private void build(int[] input, int v, int left, int right) {
        if (left == right) {
            arr[v] = input[left];
        } else {
            int mid = left + (right - left) / 2;
            build(input, v * 2, left, mid);
            build(input, v * 2 + 1, mid + 1, right);
        }
    }

    private void update(int vertex, int currLeft, int currRight, int left, int right, int diff) {
        if (left > currRight || currLeft > right) {
            return;
        } else if (currLeft == left && currRight == right) {
            arr[vertex] += diff;
        } else {
            int currMid = currLeft + (currRight - currLeft) / 2;
            update(vertex * 2, currLeft, currMid, left, Math.min(right, currMid), diff);
            update(vertex * 2 + 1, currMid + 1, currRight, Math.max(left, currMid + 1), right, diff);
        }
    }


    private int getN(int vertex, int currLeft, int currRight, int n) {
        if (currLeft == currRight) {
            return arr[vertex];
        }
        int mid = currLeft + (currRight - currLeft) / 2;
        arr[vertex * 2] += arr[vertex];
        arr[vertex * 2 + 1] += arr[vertex];
        if (n <= mid) {
            return getN(vertex * 2, currLeft, mid, n);
        } else {
            return getN(vertex * 2 + 1, mid + 1, currRight, n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int q = Integer.parseInt(dimensions[1]);
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        SegmentTree segmentTree = new SegmentTree(arr);
        for (int i = 0; i < q; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (input[0] == 2) {
                System.out.println(segmentTree.getN(1, 0, n - 1, input[1] - 1));
            } else {
                segmentTree.update(1, 0, 7, input[1] - 1, input[2] - 1, input[3]);
            }
        }
    }


//    public static void main(String[] args) {
//        SegmentTree segmentTree = new SegmentTree(new int[]{3, 2, 4, 5, 1, 1, 5, 3});
//        System.out.println(segmentTree.getN(1, 0, 7, 3));
//        segmentTree.update(1, 0, 7, 1, 4, 1);
//        System.out.println(segmentTree.getN(1, 0, 7, 3));
//        System.out.println(segmentTree.getN(1, 0, 7, 1));
//        System.out.println(segmentTree.getN(1, 0, 7, 8));
//    }
}
