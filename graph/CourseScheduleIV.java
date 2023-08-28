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


    public List<Boolean> checkIfPrerequisiteII(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new List[numCourses];
        Set<Integer>[] denormalized = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
            denormalized[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(i, graph, denormalized, visited);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(denormalized[query[0]].contains(query[1]));
        }
        return ans;
    }

    private Set<Integer> dfs(int curr, List<Integer>[] graph, Set<Integer>[] denormalized, boolean[] visited) {
        if (visited[curr])
            return denormalized[curr];
        visited[curr] = true;
        for (int next : graph[curr]) {
            denormalized[curr].addAll(dfs(next, graph, denormalized, visited));
        }
        denormalized[curr].add(curr);
        return denormalized[curr];
    }


    public static void main(String[] args) {
        CourseScheduleIV scheduleIV = new CourseScheduleIV();
        System.out.println(scheduleIV.checkIfPrerequisiteII(3, new int[][]{{1,2}, {1,0}, {2,0}}, new int[][]{{1,0},{1,2}}));
    }
}
