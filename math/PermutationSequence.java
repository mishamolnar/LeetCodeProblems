package LeetCode.math;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//https://leetcode.com/problems/permutation-sequence/submissions/
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int range = IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        k--;

        while (!list.isEmpty()) {
            range /= list.size();
            int index = k / range;
            k -= (index * range);
            sb.append(list.get(index));
            list.remove(index);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4, 9));
    }
}
