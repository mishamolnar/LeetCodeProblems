package LeetCode.arrays;

import java.util.*;

public class RandomizedSet {
    Random random;
    HashMap<Integer, Integer> map; //val -> index in list
    List<Integer> list;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        if (map.get(val) < list.size() - 1)
            overrideWithLast(map, list, map.get(val));
        else {
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    private void overrideWithLast(HashMap<Integer, Integer> map, List<Integer> list, int i) {
        map.remove(list.get(i));
        map.put(list.get(list.size() - 1), i);
        list.set(i, list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
    }
}
