package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/intersection-of-three-sorted-arrays/
public class IntersectionOfThreeSortedArrays {

    public List<Integer> arraysIntersectionPointers(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int one = 0, two = 0, three = 0;
        while (one < arr1.length && two < arr2.length && three < arr3.length) {
            if (arr1[one] == arr2[two] && arr2[two] == arr3[three]) {
                ans.add(arr1[one]);
                one++;
                two++;
                three++;
            } else {
                if (arr1[one] < arr2[two]) {
                    one++;
                } else if (arr2[two] < arr3[three]) {
                    two++;
                } else three++;
            }
        }
        return ans;
    }

    //counting
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[2001];
        for (int j : arr1) freq[j]++;
        for (int j : arr2) freq[j]++;
        for (int j : arr3) freq[j]++;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 3) ans.add(i);
        }
        return ans;
    }
}
