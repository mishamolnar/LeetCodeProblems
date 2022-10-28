package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Floyd warshall
public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] arr = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            arr[pre[0]][pre[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            list.add(arr[query[0]][query[1]]);
        }
        return list;
    }


    public static void main(String[] args) {
        CourseScheduleIV scheduleIV = new CourseScheduleIV();
        System.out.println(scheduleIV.checkIfPrerequisite(3, new int[][]{{1,2}, {1,0}, {2,0}}, new int[][]{{1,0},{1,2}}));
    }
}
