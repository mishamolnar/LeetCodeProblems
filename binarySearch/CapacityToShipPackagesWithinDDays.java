package LeetCode.binarySearch;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 50;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int count = 0, curr = 0;
        for (int nums : weights) {
            if (nums > cap) return false;
            if (curr + nums > cap) {
                count++;
                curr = nums;
            } else curr += nums;
        }
        count += curr == 0 ? 0 : 1;
        return count <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
