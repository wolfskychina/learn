package leetcode.a2000;
/**
 * 按键变更的次数
 * {easy}
 */
public class _3019Solution {
   
    public int countKeyChanges(String s) {

        char [] input = s.toLowerCase().toCharArray();
        int count = 0;
        for(int i=1;i<input.length;i++){
            if(input[i] != input[i-1])

            count++;
        }
        return count;
    }
}
