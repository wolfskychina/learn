package leetcode.a100;

import java.util.HashMap;
/**
 * 将分数形式改为小数带括号循环的写法
 */
public class _166Solution {

    public String fractionToDecimal(int numerator, int denominator){

        if(numerator ==0){
            return "0";}

        StringBuilder res = new StringBuilder();

        res.append(((numerator>0)^(denominator>0))?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        res.append(num/den);
        num %= den;
        if(num==0){
            return res.toString();
        }

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        // 整数部分冗余的余数作为map中的第一个值,value标记左括号需要插入的位置
        map.put(num, res.length());
        while(num!=0){
            num *=10;
            res.append(num/den);
            num %=den;
            if(map.containsKey(num)){
                // 开始出现重复的循环
                int index = map.get(num);
                // TODO StringBuilder.insert(indxt,str);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else{
                // 每个余数都要记录，直到遇到曾经出现过的余数为止
                map.put(num, res.length());
            }
        }

        return res.toString();
    }
}
