package leetcode.a300;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 353. Design Snake Game
 * TODO 
 */
public class _353Solution {

    class SnakeGame {

        Set<Entry<Integer, Integer>> snakeSet;
        Deque<Entry<Integer, Integer>> snake;
        int[][] food;
        int foodIndex;
        int width;
        int height;

        class Entry<T, K> {
            T key;
            K value;

            public Entry(T key, K value) {
                this.key = key;
                this.value = value;
            }

        }

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.snakeSet = new HashSet<Entry<Integer, Integer>>();
            this.snakeSet.add(new Entry<Integer, Integer>(0, 0));
            this.snake = new LinkedList<Entry<Integer, Integer>>();
            this.snake.offerLast(new Entry<Integer, Integer>(0, 0));
        }

        public int move(String direction) {

            Entry<Integer, Integer> snakeCell = this.snake.peekFirst();
            int newHeadRow = snakeCell.key;
            int newHeadCol = snakeCell.value;

            switch (direction) {

                case "U":
                    newHeadRow--;
                    break;
                case "D":
                    newHeadRow++;
                    break;
                case "L":
                    newHeadCol--;
                    break;
                case "R":
                    newHeadCol++;
                    break;

            }

            Entry<Integer, Integer> newHead = new Entry<>(newHeadRow, newHeadCol);
            Entry<Integer, Integer> currTail = this.snake.peekLast();

            // 是否走到边界
            boolean horiBoundary = newHeadRow < 0 || newHeadRow >= height;
            boolean vetiBoundary = newHeadCol < 0 || newHeadCol >= width;

            // 是否走到自己身上
            boolean ifBiteSelf = this.snakeSet.contains(newHead)
                    && !(newHead.key == currTail.key && newHead.value == currTail.value);

            if (horiBoundary || vetiBoundary || ifBiteSelf)
                return -1;

            if ((this.foodIndex < this.food.length) &&
                    (food[foodIndex][0] == newHeadRow) &&
                    (food[foodIndex][1] == newHeadCol)) {
                foodIndex++;
                // 吃掉食物，长度加一，尾巴不需要移动
            } else {
                // 尾巴向前移动
                snake.pollLast();
                snakeSet.remove(currTail);
            }

            // 加入头结点
            snake.addFirst(newHead);
            snakeSet.add(newHead);

            return snake.size() - 1;

        }

    }
}
