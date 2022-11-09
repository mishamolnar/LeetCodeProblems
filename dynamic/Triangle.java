package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size() - 1; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int i1 = 0; i1 < triangle.get(i + 1).size(); i1++)
                curr.add(Integer.MAX_VALUE);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i + 1).set(j,
                        Math.min(curr.get(j), triangle.get(i).get(j) + triangle.get(i + 1).get(j)));
                triangle.get(i + 1).set(j + 1,
                        Math.min(curr.get(j + 1), triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1)));
            }
            triangle.set(i + 1, curr);
        }
        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
//        triangle.minimumTotal(new ArrayList<>(List.of(
//                new ArrayList(List.of(2)),
//                new ArrayList(List.of(3,4)),
//                new ArrayList(List.of(6,5,7)),
//                new ArrayList(List.of(4,1,8,3)))));
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
    }
}
