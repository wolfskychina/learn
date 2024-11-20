package leetcode.a0;

import java.util.Stack;

/**
 * trap water problem
 */
public class _42Solution {

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int left = 1;
        int right = height.length - 2;
        int max = 0;
        int tmp = 0;
        int sum = 0;
        int sum2 = 0;
        int lefttop = 0;
        int righttop = 0;
        //find max num
        for (int i = 0; i < height.length; i++) {
            sum2 += height[i];
            if (height[i] > max) {
                max = height[i];
                lefttop = i;
            }
        }
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] == max) {
                righttop = i;
                break;
            }
        }

        sum = max - height[0] + max - height[height.length - 1];

        tmp = 0;
        while (left < lefttop) {

            if (height[left] > height[tmp]) {
                tmp = left;
            }
            sum += max - height[tmp];
            // System.out.println("max-tmp is:"+(max-height[tmp]));
            left++;
        }

        tmp = height.length - 1;
        while (right > righttop) {
            if (height[right] > height[tmp]) {
                tmp = right;
            }
            sum += max - height[tmp];
            right--;
        }

        return max * height.length - sum - sum2;
    }

    /**
     * {monotonic stack}
     * 单调栈，木桶原理
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                // 只有这种情况下i才向右移动
                // 一个挡板当完右挡板还可以当左挡板
                // 如果一直是这个条件说明没法形成容纳雨水的凹槽
                s.push(i++);
            } else {
                // 这个分支中i不会增加,会一直出栈，直到把左边的容量全部计算出来
                // t是本次计算的底部
                int t = s.pop();
                if (s.isEmpty()) continue;
                System.out.println("left height is :"+ height[s.peek()]);
                System.out.println("right height is :"+ height[i]);
                System.out.println("bottom is :"+height[t]);
                System.out.println("left index is:"+s.peek()+" right index is:"+i);
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args){
            _42Solution so = new _42Solution();
            int[] a = {1,1,1,2,1,0,2};
            System.out.println(so.trap2(a));


    }
}
