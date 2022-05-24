package LeetCode.arrays;

import java.util.Arrays;


//https://leetcode.com/problems/boats-to-save-people/submissions/
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, right = people.length - 1, left = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) left++;
            if (left == right) res++;
            right--;
            res++;
        }
        return res;
    }
}
