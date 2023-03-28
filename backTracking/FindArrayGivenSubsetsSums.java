package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/find-array-given-subset-sums/description/
public class FindArrayGivenSubsetsSums {


    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        if (sums.length == 2) {
            return new int[]{sums[0] == 0 ? sums[1] : sums[0]};
        }
        int[] res = new int[getSize(sums.length)];
        int[] left = new int[sums.length / 2];
        int[] right = new int[sums.length / 2];
        int diff = sums[1] - sums[0], leftCounter = 0, rightCounter = 0;
        Map<Integer, Integer> set = new HashMap<>();
        for (int sum : sums) {
            if (set.getOrDefault(sum - diff, 0) > 0) {
                left[leftCounter++] = sum - diff;
                set.put(sum - diff, set.get(sum - diff) - 1);
                right[rightCounter++] = sum;
            } else set.put(sum, set.getOrDefault(sum, 0) + 1);
        }
        int[] rest;
        if (Arrays.stream(left).anyMatch((a) -> a == 0)) {
            res[0] = diff;
            rest = recoverArray(n - 1, left);
        } else {
            res[0] = -diff;
            rest = recoverArray(n - 1, right);
        }
        System.arraycopy(rest, 0, res, 1, rest.length);
        return res;
    }

    private int getSize(int len) {
        int size = 0;
        while (len % 2 == 0) {
            size++;
            len /= 2;
        }
        return size;
    }


    private List<Integer> getSubsets(int[] arr) {
        List<Integer> res = new ArrayList<>();
        backtrack(arr, res, 0,0);
        return res;
    }

    private void backtrack(int[] arr, List<Integer> res, int sum, int index) {
        if (index == arr.length) {
            res.add(sum);
            return;
        }
        backtrack(arr, res, sum + arr[index], index + 1);
        backtrack(arr, res, sum, index + 1);
    }


    public static void main(String[] args) {
        FindArrayGivenSubsetsSums find = new FindArrayGivenSubsetsSums();
        List<Integer> arr = find.getSubsets(new int[]{1, 2, 3, 1});
        System.out.println(arr);
        arr.sort(Integer::compareTo);
        System.out.println(arr);
        System.out.println(Arrays.toString(find.recoverArray(3, new int[]{-3,-2,-1,0,0,1,2,3})));
    }
}
