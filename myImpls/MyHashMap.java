package LeetCode.myImpls;

//https://leetcode.com/problems/design-hashmap/submissions/
public class MyHashMap {
    int[][] arr;
    int increment = 2;
    double treashhold = 0.75;
    int size = 0;

    public MyHashMap() {
        arr = new int[16][];
    }

    public void put(int key, int value) {
        if (arr[key % arr.length] != null) {
            arr[key % arr.length][1] = value;
        } else {
            arr[key % arr.length] = new int[]{key, value};
            size++;
            if ((double) (size / arr.length) > treashhold) resize();
        }
    }

    public int get(int key) {
        if (this.arr[key % arr.length] == null) return -1;
        return this.arr[key % arr.length][1];
    }

    public void remove(int key) {
        this.arr[key % arr.length] = null;
    }

    private void resize() {
        int[][] newArr = new int[arr.length * increment][];
        int[][] old = this.arr;
        this.arr = newArr;
        for (int[] ints : old) {
            if (ints != null) put(ints[0], ints[1]);
        }
    }
}
