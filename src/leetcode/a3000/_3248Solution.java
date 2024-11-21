package leetcode.a3000;

import java.util.List;

/**
 * 执行移动命令后的最终位置
 * {easy}
 */
public class _3248Solution {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String str : commands) {
            switch (str) {
                case "DOWN":
                    i++;
                    break;
                case "UP":
                    i--;
                    break;
                case "LEFT":
                    j--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                default:
                    break;
            }
        }
        return i * n + j;
    }
}
