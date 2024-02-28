package leetcode.a2000;
/**
 * 一个有效的时间表达式 TT:MM 如果其中有？通配符
 * 共有多少种可能的时间
 * {easy}
 */
public class _2437Solution {
   
    public int countTime(String time) {

        int num = 1;
        
        if(time.charAt(0)=='?'&&time.charAt(1)=='?'){
            num *= 24;
        }else if(time.charAt(0)=='?'&&time.charAt(1)!='?'){
            if(time.charAt(1) >= '4'){
                    num*=2;
            }else{
                num*=3;
            }
        }else if(time.charAt(0)!='?'&&time.charAt(1)=='?'){
            if(time.charAt(0)<'2'){
                num*=10;
            }else{
                num*=4;
            }
        }

        if(time.charAt(3)=='?')
            num *=6;
        if(time.charAt(4)=='?')
            num *=10;

        return num;
    }
}
