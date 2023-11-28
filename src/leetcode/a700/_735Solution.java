package leetcode.a700;

import java.util.Stack;
/**
 * 行星碰撞，一行的行星按照不同的方向运动，碰撞时尺寸大的保留，如果一样大就都消失
 */
public class _735Solution {

    /**
     * 使用栈模拟，速度一般
     * {stack} 
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> s = new Stack<>();

        for (int i : asteroids) {

            if (i > 0) {
                s.push(i);
            } else {
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(i);
                } else {
                    while (!s.isEmpty() && s.peek() > 0) {
                        if (s.peek() + i < 0) {
                            // i += s.peek();
                            s.pop();

                        } else if (s.peek() + i == 0) {
                            i = 0;
                            s.pop();
                            break;
                        } else {
                            // s.push(s.pop()+i);
                            i = 0;
                            break;
                        }
                    }
                    if (i != 0) {
                        s.push(i);
                    }
                }
            }
        }

        int res[] = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;

    }


}
