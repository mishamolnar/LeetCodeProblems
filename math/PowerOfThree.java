package LeetCode.math;


//https://leetcode.com/problems/power-of-three/submissions/
public class PowerOfThree {

    //1162261467  найбильший доступний степінь тройки
    //тобто остача від ділення всіх інших степенів тройки має бути 0
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
