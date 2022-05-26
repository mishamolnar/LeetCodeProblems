package LeetCode.arrays;

//https://leetcode.com/problems/flatten-2d-vector/
public class Vector2D {
    int[][] arr;
    int x = 0;
    int y = 0;


    //O(1)
    public Vector2D(int[][] vec) {
        this.arr = vec;
    }

    //O(1)
    public int next() {
        if (!hasNext()) throw new IllegalArgumentException();
        return arr[x][y++];
    }

    // Let N be the number of integers within the 2D Vector, and VV be the number of inner vectors
    //O(N + V) - worst case
    public boolean hasNext() {
        advanceToNext();
        return x < arr.length;
    }

    //O(N + V) = - worst case
    private void advanceToNext() {
        while (x < arr.length && arr[x].length == y) {
            y = 0;
            x++;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{};
        Vector2D vector2D = new Vector2D(arr);
        System.out.println(vector2D.hasNext()); // return True

//        System.out.println(vector2D.next());    // return 1
//        System.out.println(vector2D.next());    // return 2
//        System.out.println(vector2D.next());    // return 3
//        System.out.println(vector2D.hasNext()); // return True
//        System.out.println(vector2D.hasNext()); // return True
//        System.out.println(vector2D.next());    // return 4
//        System.out.println(vector2D.next());    // return 5
//        System.out.println(vector2D.hasNext()); // return True
//        System.out.println(vector2D.next());    // return 6
//        System.out.println(vector2D.hasNext()); // return False
    }
}
