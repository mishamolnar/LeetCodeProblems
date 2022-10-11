package LeetCode.arrays;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        long one = Long.MAX_VALUE, two = Long.MAX_VALUE, three = Long.MAX_VALUE;
        for (int num : nums) {
            one = Math.min(num, one);
            if (num > one)
                two = Math.min(two, num);
            if (num > two)
                three = Math.min(three, num);
        }
        return three != Long.MAX_VALUE;
    }
}
