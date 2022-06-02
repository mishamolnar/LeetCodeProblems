package LeetCode.arrays;


//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
public class MinimumSwapsToGroupAllOnesTogether {

    //O(n) time and constant space
    public int minSwaps(int[] data) {
        int count = 0;
        for (int datum : data) {
            if (datum == 1) count++; // рахуємо всі одиничики - тим  самим визначаючи довжину підмасиву який має бути згрупований
        }
        int left = 0, max = 0, curr = 0;
        for (int i = 0; i < data.length; i++) {
            curr += data[i];
            while (i - left >= count) curr -= data[left++];
            max = Math.max(max, curr); //дивимось найбільше одиничок стоїть підряд в підмасиві довжиною в count
        }
        return count - max; //відповідно треба свапнути count - max (найменша кількість нуликів в підмасиві)
    }
}
