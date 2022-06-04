package LeetCode.backTracking;

import java.util.*;

public class RobotRoomCleaner {
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Map.Entry<Integer, Integer>> visited = new HashSet();
    Robot robot;

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void backtrack(int row, int col, int d) {
        visited.add(new AbstractMap.SimpleImmutableEntry<>(row, col));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int newCol = row + directions[newD][0];
            int newRow = row + directions[newD][1];

            if (!visited.contains(new AbstractMap.SimpleImmutableEntry<>(newRow, newCol)) && robot.move()) {
                backtrack(newCol, newRow, newD);
                goBack();
            }

            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }



    // This is the robot's control interface.
    // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

}
