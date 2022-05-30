package LeetCode.matrixes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;


//https://leetcode.com/problems/design-snake-game/solution/
public class SnakeGame {
    private boolean[][] snake;
    private Deque<int[]> queue;
    private int[][] food;
    private int score; //pointer for food array as well

    // 0(nm) space and constant time
    public SnakeGame(int width, int height, int[][] food) {
        queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        snake = new boolean[height][width];
        score = 0;
        this.food = food;
    }

    public int move(String direction) {
        if (score == -1) return score;
        int[] curr = queue.getFirst();
        int[] next;
        if (direction.equals("U")) {
            next = new int[]{curr[0] - 1, curr[1]};
        } else if (direction.equals("D")) {
            next = new int[]{curr[0] + 1, curr[1]};
        } else if (direction.equals("R")) {
            next = new int[]{curr[0], curr[1] + 1};
        } else next = new int[]{curr[0], curr[1] - 1};
        if (next[0] < 0 || next[1] < 0 || next[0] >= snake.length || next[1] >= snake[0].length) {
            score = -1;
            return -1;
        }
        if (snake[next[0]][next[1]] && !Arrays.equals(next, queue.getLast())) {
            score = -1;
            return -1;
        }
        if (score >= food.length || food[score][0] != next[0] || food[score][1] != next[1]) {
            int[] arr = queue.removeLast();
            snake[arr[0]][arr[1]] = false;
        } else score++;
        queue.addFirst(next);
        return score;
    }


    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
        snakeGame.move("R"); // return 0
        snakeGame.move("D"); // return 0
        snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
        snakeGame.move("U"); // return 1
        snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
        snakeGame.move("U"); // return -1, game over because snake collides with border
    }
}

//LC premium solution
//class SnakeGame {
//
//HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
//Deque<Pair<Integer, Integer>> snake;
//int[][] food;
//int foodIndex;
//int width;
//int height;
//
///**
// * Initialize your data structure here.
// *
// * @param width - screen width
// * @param height - screen height
// * @param food - A list of food positions E.g food = [[1,1], [1,0]] means the first food is
// *     positioned at [1,1], the second is at [1,0].
// */
//public SnakeGame(int width, int height, int[][] food) {
//    this.width = width;
//    this.height = height;
//    this.food = food;
//    this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();
//    this.snakeMap.put(new Pair<Integer, Integer>(0,0), true); // intially at [0][0]
//    this.snake = new LinkedList<Pair<Integer, Integer>>();
//    this.snake.offerLast(new Pair<Integer, Integer>(0,0));
//}
//
///**
// * Moves the snake.
// *
// * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
// * @return The game's score after the move. Return -1 if game over. Game over when snake crosses
// *     the screen boundary or bites its body.
// */
//public int move(String direction) {
//
//    Pair<Integer, Integer> snakeCell = this.snake.peekFirst();
//    int newHeadRow = snakeCell.getKey();
//    int newHeadColumn = snakeCell.getValue();
//
//    switch (direction) {
//    case "U":
//        newHeadRow--;
//        break;
//    case "D":
//        newHeadRow++;
//        break;
//    case "L":
//        newHeadColumn--;
//        break;
//    case "R":
//        newHeadColumn++;
//        break;
//    }
//
//    Pair<Integer, Integer> newHead = new Pair<Integer, Integer>(newHeadRow, newHeadColumn);
//    Pair<Integer, Integer> currentTail = this.snake.peekLast();
//
//    // Boundary conditions.
//    boolean crossesBoundary1 = newHeadRow < 0 || newHeadRow >= this.height;
//    boolean crossesBoundary2 = newHeadColumn < 0 || newHeadColumn >= this.width;
//
//    // Checking if the snake bites itself.
//    boolean bitesItself = this.snakeMap.containsKey(newHead) && !(newHead.getKey() == currentTail.getKey() && newHead.getValue() == currentTail.getValue());
//
//    // If any of the terminal conditions are satisfied, then we exit with rcode -1.
//    if (crossesBoundary1 || crossesBoundary2 || bitesItself) {
//        return -1;
//    }
//
//    // If there's an available food item and it is on the cell occupied by the snake after the move,
//    // eat it.
//    if ((this.foodIndex < this.food.length)
//        && (this.food[this.foodIndex][0] == newHeadRow)
//        && (this.food[this.foodIndex][1] == newHeadColumn)) {
//        this.foodIndex++;
//    } else {
//        this.snake.pollLast();
//        this.snakeMap.remove(currentTail);
//    }
//
//    // A new head always gets added
//    this.snake.addFirst(newHead);
//
//    // Also add the head to the set
//    this.snakeMap.put(newHead, true);
//
//    return this.snake.size() - 1;
//}
//
//}
