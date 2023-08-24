package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将字符串序列按照字符特征分类
 * 字符串特征是各个字符的相对位置，相对位置特征相同的为同一类
 */
public class _249Solution {
    /**
     * 将每个字符串的每个字符都减去字符串的第一个字符，就是特征值
     * 可能会出现差为负值，需要使用模26运算
     * 注意将int直接赋值到char会报精度损失错误，需要强制转换
     */
    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> map = new HashMap<>();
        // 每个字符都减第一个字符，就是特征值
        for(String str:strings){
            char[] orign= str.toCharArray();
            char o = orign[0];
            for(int i =0; i<orign.length;i++){

                int j=((orign[i] - o) + 26) % 26 ;           
                orign[i] = (char)j;    

            }
            // new orign is the fingerprint;
            String str2 = new String(orign);

            if(map.get(str2)==null){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str2,list);
            }else{
                map.get(str2).add(str);
            }

        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> en : map.entrySet())
        {
                res.add(en.getValue());
        }

        return res;
        
    }
    
}
