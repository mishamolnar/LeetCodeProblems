package LeetCode.greedy;

//https://leetcode.com/problems/gas-station/
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i]; //скільки в нас буде бензину, якщо заправитись на цій заправці
            sum += gas[i]; //залишок об'їхавши всі заправки
        }
        if (sum < 0) return -1; // якщо залишок негативний - коло неможливе
        sum = 0;
        int minSum = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < gas.length; i++) { //знаходимо індекс перед яким залишок бензину мінімальний
            if (minSum > sum) {
                index = i;
                minSum = sum;
            }
            sum += gas[i];
        }
        return index;
    }
}
