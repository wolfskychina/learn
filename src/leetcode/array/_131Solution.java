package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

                List list1 = new ArrayList(list);
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
}
