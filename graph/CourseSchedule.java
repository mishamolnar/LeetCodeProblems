package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//link = https://leetcode.com/problems/course-schedule/submissions/
public class CourseSchedule {
    private boolean[] isMarked;
    private boolean[] onStack;
    private int[] edgeTo;
    private boolean hasCycle;

    // dfs solution time complexity O(E + V)
    // space complexity O(E+ V)
    // BFS solution is possible also -> run bfs on all nodes and check if count == numCourses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] vertices = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            vertices[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            vertices[pre[1]].add(pre[0]);
        }
        isMarked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        edgeTo = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(vertices, i);
            if (hasCycle) return false;
        }
        return true;
    }

    private void dfs(List<Integer>[] G, int V) {
        onStack[V] = true;
        isMarked[V] = true;
        for (Integer w : G[V]) {
            if (hasCycle) return;
            if (!isMarked[w]) {
                edgeTo[w] = V;
                dfs(G, w); // стандартна dfs
            }
            if (onStack[w]) {
                hasCycle = true; // якщо рекурсія прийшла в один з тих вузлів, де ще сама не закінчилась - ми знайшли коло
            }
        }
        G[V] = new LinkedList<>(); //ми знаємо що цей курс пройти можливо тому йдемо більше його не перевіряємо, оптимізація
        onStack[V] = false;
    }

    private void dfsWithCyclePrinting(List<Integer>[] G, int V) {
        onStack[V] = true;
        isMarked[V] = true;
        for (Integer w : G[V]) {
            if (hasCycle) return;
            if (!isMarked[w]) {
                edgeTo[w] = V;
                dfs(G, w); // стандартна dfs
            }
            if (onStack[w]) {
                hasCycle = true; // якщо рекурсія прийшла в один з тих вузлів, де ще сама не закінчилась - ми знайшли коло
                for (int x = V; x != w; x = edgeTo[V]) {
                    System.out.println(x);
                }
                System.out.println(w);
                System.out.println(V);
            }
        }
        G[V] = new LinkedList<>(); //ми знаємо що цей курс пройти можливо тому йдемо більше його не перевіряємо, оптимізація
        onStack[V] = false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(4, new int[][]{{0,1},{2,0},{3,1},{3,2}}));
    }
}
