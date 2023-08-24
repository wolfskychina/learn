package leetcode.a200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * 判断一个字符串能否由回文子串组成
 * 返回所有的可能组合
 */
public class _131Solution {

    HashSet<List<String>> res =null;

    public List<List<String>> partition(String s) {

        if(s==null||s.equals("")) return new ArrayList<>();

        res = new HashSet<>();

        List<String> list = new ArrayList<>();

        for(char c: s.toCharArray()){

            list.add(String.valueOf(c));
        }

        res.add(list);

        search(list);

        return new ArrayList<>(res);

    }

    private void search(List<String> list){

        for(int i=0;i<list.size()-1;i++){

            if(isValid(list.get(i)+list.get(i+1))){

                List list1 = new ArrayList<String>(list);
                list1.set(i,list.get(i)+list.get(i+1));
                list1.remove(i+1);
                res.add(list1);
                search(list1);
            }

            if(i<list.size()-2&&isValid(list.get(i)+list.get(i+1)+list.get(i+2))){

                List list2 = new ArrayList(list);
                list2.set(i,list.get(i)+list.get(i+1)+list.get(i+2));
                list2.remove(i+1);
                list2.remove(i+1);
                res.add(list2);
                search(list2);
            }
        }
    }

    private boolean isValid(String s){

        for(int i =0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }

        return true;
    }

    // 回溯法
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(s,0,list,res);
        return res;
     }
     
     public void dfs(String s, int pos, List<String> list, List<List<String>> res){
         if(pos==s.length()) res.add(new ArrayList<String>(list));
         else{
             for(int i=pos;i<s.length();i++){
                 if(isPal(s,pos,i)){
                     list.add(s.substring(pos,i+1));
                     dfs(s,i+1,list,res);
                     list.remove(list.size()-1);
                 }
             }
         }
     }
     
     public boolean isPal(String s, int low, int high){
         while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
         return true;
     }
     
}
