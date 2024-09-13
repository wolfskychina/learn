package leetcode.a3000;
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

    public int countKeyChanges1(String s) {
        int ans=0;
        for(int i=1;i<s.length();i++){
            // 将最高位置0,从而忽略大小写差异
            if((s.charAt(i)&31)!=(s.charAt(i-1)&31)){
                ans++;
            }
        }
        return ans;
    }
}
