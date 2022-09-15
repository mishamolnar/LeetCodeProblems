package LeetCode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/most-profit-assigning-work/solution/
public class MaxProfitWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(worker);
        int border = worker.length;
        int res = 0;
        for (int[] job : arr) {
            int left = 0, right = border;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (worker[mid] >= job[0]) {
                    right = mid;
                } else left = mid + 1;
            }
            res += (border - left) * job[1];
            border = left;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfitWork maxProfitWork = new MaxProfitWork();
        //[13,37,58]
        //[4,90,96]
        //[34,73,45]
        System.out.println(maxProfitWork.maxProfitAssignment(new int[]{13,37,58}, new int[]{4,90,96}, new int[]{34,73,45}));
        System.out.println(maxProfitWork.maxProfitAssignment(new int[]{2,4,6,8,10   }, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    }
}
