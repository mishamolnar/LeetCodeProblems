package LeetCode.math;

public class BulbSwitcher {

    //the idea is that only perfect square numbers have odd number of divisors
    //perfect squares are 1, 4, 9, 16
    //why only they have odd number of divisors?
    //because every divisor can produce another divisor (when we're iterating from 1 to sqrt)
    //example when we're checking divisor 3 for 15, we will automatically find 5
    //and each time we will add 2 to the result
    //except when we have divisor == num / divisor and this happens only in case of perfect square
    public int blobSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public int bulbSwitchTwo(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if (countDivisors(i) % 2 == 0)
                res++;
        }
        return res;
    }
    
    private int countDivisors(int num) {
        int res = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            res += (num % i == 0) ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(6));
    }
}
