package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class FindArrayGivenSubsetsSums {



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
    }
}
