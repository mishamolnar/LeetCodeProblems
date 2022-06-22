package LeetCode.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/sequence-reconstruction/
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Set<Integer>[] G = new Set[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) G[i] = new HashSet<>();
        int max = 1;
        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                max = Math.max(max, Math.max(sequence.get(i), sequence.get(i + 1)));  //keeping track of max value in sequences
                G[sequence.get(i)].add(sequence.get(i + 1)); //creating graph (for {1, 2, 3} 1 -> 2 and 2 -> 3
            }
        }
        if (max < nums.length) return false; //if max is less than max value in nums -> return false because it is this case: nums = [1,2,3], sequences = [[1,2]]
        for (int i = 0; i < nums.length - 1; i++) {
            if (!G[nums[i]].contains(nums[i + 1])) return false; //validating topological sort
        }
        return true; //topological sort valid
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        System.out.println(sequenceReconstruction.sequenceReconstruction(new int[]{1}, List.of(List.of(1))));
    }
}
