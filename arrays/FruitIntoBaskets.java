package LeetCode.arrays;

import java.util.HashMap;


//https://leetcode.com/problems/fruit-into-baskets/
public class FruitIntoBaskets {

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        System.out.println(fruitIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int left = 0, max = 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            hashMap.put(fruits[i], hashMap.getOrDefault(fruits[i], 0) + 1);
            while (hashMap.size() > 2) {
                hashMap.put(fruits[left], hashMap.get(fruits[left]) - 1);
                if (hashMap.get(fruits[left]) == 0) hashMap.remove(fruits[left]);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
