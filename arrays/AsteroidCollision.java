package LeetCode.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0 ) stack.add(asteroid);
            else {
                while (!stack.isEmpty() && stack.peek() > 0
                    && stack.peek() < Math.abs(asteroid)) stack.pop();
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) stack.pop();
                else if (stack.isEmpty() || stack.peek() < 0) stack.add(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{-2, -1, 1, 2})));
    }
}
