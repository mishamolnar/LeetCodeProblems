package LeetCode.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Contests {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("01"));
        Contests contests = new Contests();
        int[] monthes = new int[]{8, 10, 8};
        System.out.println(Arrays.toString(contests.smallestSubarrays(monthes)));
        System.out.println(Arrays.toString(contests.smallestSubarrays(new int[]{1,0,2,1,3})));
        System.out.println(Arrays.toString(contests.smallestSubarrays(new int[]{0})));
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int  tr = 0, res = 0;
        for (int i = 0; i < players.length; i++) {
            while(tr < trainers.length && players[i] > trainers[tr])
                tr++;
            if (tr < trainers.length && players[i] <= trainers[tr]) {
                tr++;
                res++;
            }
        }
        return res;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(Math.min(dateToNumber(leaveAlice), dateToNumber(leaveBob)) -
                Math.max(dateToNumber(arriveAlice), dateToNumber(arriveBob)), 0);
    }

    private int dateToNumber(String date) {
        int[] monthes = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        return monthes[Integer.parseInt(String.valueOf(date.split("-")[0])) - 1] +
                Integer.parseInt(String.valueOf(date.split("-")[1]));
    }

    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[nums.length];
        int[] bits = new int[32];
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            for (int j = 0; j < 30; j++) {
                if ((curr & ((int) Math.pow(2, j))) > 0)
                    bits[j]++;
            }
            while (right > i && canReduce(bits, nums[right])) {
                for (int j = 0; j < 30; j++) {
                    if ((nums[right] & ((int) Math.pow(2, j))) > 0)
                        bits[j]--;
                }
                right--;
            }
            res[i] = right - i + 1;
        }
        return res;
    }

    private boolean canReduce(int[] bits, int num) {
        for (int j = 0; j < 30; j++) {
            if ((num & ((int) Math.pow(2, j))) > 0 && bits[j] == 1)
                return false;
        }
        return true;
    }


    public long minimumMoney(int[][] transactions) {
        HashSet<Integer> used = new HashSet<>();
        int res = 0, sum = 0, cash = 0;
        while (used.size() != transactions.length) {
            int currMax = -1;
            for (int i = 0; i < transactions.length; i++) {
                if (used.contains(i))
                    continue;
                if (currMax == -1 || transactions[i][0] > transactions[currMax][0] ||
                    (transactions[i][0] == transactions[currMax][0] && transactions[i][1] < transactions[currMax][1]))
                    currMax = i;
            }
            used.add(currMax);
            sum += transactions[currMax][0];
            sum -= used.size() == transactions.length ? 0 : cash;
            cash = transactions[currMax][1];
            res = Math.max(res, sum);
        }
        return sum;
    }

}
