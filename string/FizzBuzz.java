package LeetCode.string;

import java.util.ArrayList;
import java.util.List;


//link - https://leetcode.com/problems/fizz-buzz/submissions/
public class FizzBuzz {

    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) result.add("FizzBuzz");
            else if (i % 3 == 0) result.add("Fizz");
            else if (i % 5 == 0) result.add("Buzz");
            else result.add(String.valueOf(i));
        }
        return result;
    }
}
