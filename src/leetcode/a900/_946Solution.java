package leetcode.a900;

import java.util.Stack;
/**
 * 给定一个入栈顺序和一个出栈顺序
 * 判断这个顺序是否是合法能够发生的
 * {stack},{simulation}
 */
public class _946Solution {
   
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushidx = 1;
        int popidx =0;
        Stack<Integer> s = new Stack<>();
        s.push(pushed[0]);
        // 终止条件比较复杂
        // 单纯pushidx=pushed.length的时候还不能终止
        // 因为popped可能还没有结束，仍然可以继续弹出
        while(pushidx<pushed.length||popidx<popped.length){
            if(popidx<popped.length&&!s.isEmpty()&&s.peek()==popped[popidx]){
                s.pop();
                popidx++;
            }else if(pushidx<pushed.length){
                s.push(pushed[pushidx++]);
            }else{
                return false;
            }
        }

        return s.isEmpty()&&pushidx==pushed.length&&popidx == pushed.length;

    }
}
