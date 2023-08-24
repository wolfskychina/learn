package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义一个数据结构来保存单词在字典中出现的特征
 * 并且实现一个方法来返回两个单词的最短距离
 */
public class _244Solution {
    /**
     * Your WordDistance object will be instantiated and called as such:
     * WordDistance obj = new WordDistance(wordsDict);
     * int param_1 = obj.shortest(word1,word2);
     */
    Map<String, List<Integer>> map;
    public _244Solution(String[] words) {
        map=new HashMap<String, List<Integer>>();
        for(int i=0; i<words.length; i++){
            String temp=words[i];
            if(map.containsKey(temp)){
                map.get(temp).add(i);
            }else{
                List<Integer> list=new ArrayList<Integer>();
                list.add(i);
                map.put(temp, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min=Integer.MAX_VALUE;
        List<Integer> list1=map.get(word1);
        List<Integer> list2=map.get(word2);
        int size1=list1.size(), size2=list2.size();
        int i=0, j=0;
        while(i< size1 && j<size2){
            int t1=list1.get(i), t2=list2.get(j);
            if(t1<t2){
                min=Math.min(min, t2-t1);
                i++;
            }else{
                min=Math.min(min, t1-t2);
                j++;
            }
        }
        return min;
    }
}
