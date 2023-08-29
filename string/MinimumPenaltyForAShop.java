package LeetCode.string;

public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int emptyHoursCount = 0, customersCount = 0, res = Integer.MAX_VALUE, hour = -1;
        char[] arr = customers.toCharArray();
        for (char c : arr)
            customersCount = c == 'Y' ? 1 : 0;
        for (int i = 0; i <= arr.length; i++) {
            if (customersCount + emptyHoursCount < res) {
                res = customersCount + emptyHoursCount;
                hour = i;
            }
            if (i < arr.length) {
                customersCount -= (arr[i] == 'Y') ? 1 : 0;
                emptyHoursCount += (arr[i] == 'N') ? 1 : 0;
            }
        }
        return hour;
    }
}
