package leetcode.a1600;
/**
 * 杯赛的配对次数
 * TODO 注意&操作符的优先级比四则运算要低
 * {bit manuplation} 
 */
public class _1688Solution {
   
    public int numberOfMatches(int n) {
        int count =0;
        while(n!=1){
            int tmpmatch = n>>1;
            count+=tmpmatch;
            // &的优先级比较低，需要加括号
            n = tmpmatch + (n&1);
        }
        return count;
    }

    public static void main(String[] args){
        _1688Solution so = new _1688Solution();
        so.numberOfMatches(7);
        
    }
}
