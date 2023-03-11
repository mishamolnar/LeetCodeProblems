package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

class SnapshotArray {
    private List<Integer>[] arr;
    private int snap;

    public SnapshotArray(int length) {
        this.arr = new List[length];
        this.snap = 0;
    }
    
    public void set(int index, int val) {
        if (arr[index] == null)
            arr[index] = new ArrayList<>();
        while (arr[index].size() < snap)
            arr[index].add(arr[index].isEmpty() ? 0 : arr[index].get(arr[index].size() - 1));
        if (arr[index].size() > snap)
            arr[index].set(snap, val);
        else arr[index].add(val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        if (arr[index] == null)
            return 0;
        return arr[index].size() <= snap_id ? arr[index].get(arr[index].size() - 1) : arr[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */