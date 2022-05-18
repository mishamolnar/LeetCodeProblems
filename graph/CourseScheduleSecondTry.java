package LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleSecondTry {
    boolean[] marked;
    boolean[] visited;
    boolean canFinish = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] arr = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (arr[prerequisites[i][0]] == null) arr[prerequisites[i][0]] = new ArrayList<>();
            arr[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i, arr);
        }
        return canFinish;
    }

    private void dfs(int current, List<Integer>[] arr) {
        if (arr[current] == null || visited[current]) return;
        visited[current] = true;
        marked[current] = true;
        for (int i = 0; i < arr[current].size(); i++) {
            if (marked[arr[current].get(i)]) {
                canFinish = false;
                break;
            } else dfs(arr[current].get(i), arr);
        }
        marked[current] = false;
    }

    public static void main(String[] args) {
        CourseScheduleSecondTry courseScheduleSecondTry = new CourseScheduleSecondTry();
        System.out.println(courseScheduleSecondTry.canFinish(2, new int[][]{{1,0}}));
    }
}
