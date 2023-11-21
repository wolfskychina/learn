package leetcode.a600;
/**
 * 灯泡开关
 * 4个开关，每个开关控制一部分灯的亮灭反转
 * 每次允许拨动一个开关，问presses次拨动之后，总共有多少种不同的灯的排列
 */
public class _672Solution {
   
    /**
     * 根据4个按钮控制的灯的情况，可以发现每六组灯的亮灭规律是一致的
     * 随后前6个灯里面，4,6和3,5灯的循环规律也是一致的，所以只需要考虑前四个
     * 然后根据1,3的状态，可以确定第4个开关的奇偶性，然后根据第4个开关的奇偶性
     * 可以确定第4个灯的状态，所以只要有1,2,3个灯的状态，第4个灯的状态也是唯一的
     * 所以最多只需要看3个灯的状态
     * {TODO}
     * 
     * @param n
     * @param presses
     * @return
     */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

}
