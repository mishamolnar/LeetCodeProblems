package LeetCode.arrays;

import java.util.List;

//https://leetcode.com/problems/zigzag-iterator/
public class ZigzagIterator {
    private int first = 0;
    private int second = 0;
    private List<Integer> v1;
    private List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (first < v1.size() && (first == second || second >= v2.size())) {
            return v1.get(first++);
        } else return v2.get(second++);
    }

    public boolean hasNext() {
        return first < v1.size() || second < v2.size();
    }

    public static void main(String[] args) {

    }
}
