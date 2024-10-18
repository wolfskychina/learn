package leetcode.a1300;
/**
 * 生成每种字符都是奇数次数的字符串
 * {easy}
 */
public class _1374Solution {
   
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-1;i++){
            sb.append('a');
        }
        if(n%2==0){
            sb.append('b');
        }else{
            sb.append('a');
        }
        return sb.toString();
    }
}
