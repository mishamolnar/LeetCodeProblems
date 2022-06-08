package LeetCode.bitManipulation;

//https://leetcode.com/problems/remove-9/
public class RemoveNine {
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
