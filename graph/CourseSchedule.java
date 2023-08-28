package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//link = https://leetcode.com/problems/course-schedule/submissions/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //plan: create a graph -> where (a) -> (b) indicates first a then b
        //then create array visited and create array inStack
        //then detect cycle by array inStack
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        boolean[] stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, -1, graph, stack, visited))
                return false;
        }
        return true;
    }

    private boolean hasCycle(int curr, int prev, List<Integer>[] graph, boolean[] stack, boolean[] visited) {
        visited[curr] = true;
        stack[curr] = true;
        for (Integer next : graph[curr]) {
            if (stack[next])
                return true;
            else if (!visited[next] && hasCycle(next, curr, graph, stack, visited))
                return true;
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, new int[][]{{0,1},{1,0}}));
    }
}
