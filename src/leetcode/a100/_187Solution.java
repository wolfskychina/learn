package leetcode.a100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 查找重复出现的定长DNA序列
 */
public class _187Solution {

    public List<String> findRepeatedDnaSequences(String s) {
       
        Map<String,Integer> count = new HashMap<>();
        // 注意i的终止条件
        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i, i+10);
           
            count.put(sub, count.getOrDefault(sub,0)+1);
         
        }

        List<String> res = new ArrayList<>();
        for(Entry<String, Integer> en:count.entrySet()){
            if(en.getValue()>1)
                res.add(en.getKey());
        }

        return res;
    } 

    /**
     * 直接使用HashSet，更快
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> set=new HashSet<>(),rep=new HashSet<>();
        for(int i=0;i<s.length()-9;i++)
        {
            String sub=s.substring(i,i+10);
            if(set.contains(sub))
                rep.add(sub);
            set.add(sub);
        }
        return new ArrayList<String>(rep);
    }

    public static void main(String[] args){
        _187Solution so = new _187Solution();
        List<String> list = so.findRepeatedDnaSequences("AAAAAAAAAAA");
        for(String str : list){
            System.out.println(str);
        }
    }
}
